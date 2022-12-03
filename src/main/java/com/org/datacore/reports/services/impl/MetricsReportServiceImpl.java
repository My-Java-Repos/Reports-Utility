package com.org.datacore.reports.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.datacore.reports.clinical.model.ClinicalChart;
import com.org.datacore.reports.clinical.model.ClinicalChartReport;
import com.org.datacore.reports.clinical.model.FileInfo;
import com.org.datacore.reports.clinical.model.MemberInfo;
import com.org.datacore.reports.clinical.model.PatientGapsInfo;
import com.org.datacore.reports.clinical.model.PatientInfo;
import com.org.datacore.reports.model.MetricsReport;
import com.org.datacore.reports.model.ReportInput;
import com.org.datacore.reports.repository.ClinicalChartReportRepository;
import com.org.datacore.reports.repository.MetricsReportRepository;
import com.org.datacore.reports.service.MetricsReportService;
import com.org.datacore.reports.util.ClinicalChartReportExcelFileExporter;
import com.org.datacore.reports.util.DocumentReport;
import com.org.datacore.reports.util.ExcelFileExporter;

@Service
public class MetricsReportServiceImpl implements MetricsReportService {

	private static final Logger logger = LoggerFactory.getLogger(MetricsReportServiceImpl.class);

	@Autowired
	MetricsReportRepository repository;

	@Autowired
	ClinicalChartReportRepository clinicalChartRepository;

	@Autowired
	DocumentReport docReport;

	@Autowired
	ExcelFileExporter fileService;

	@Autowired
	ClinicalChartReportExcelFileExporter clinicalFileService;

	@Override
	public MetricsReport getMetricsReport(ReportInput reportInput) {

		MetricsReport metricsReport = new MetricsReport();

		metricsReport.setUniqueUsers(repository.getUniqueUsers(reportInput));

		metricsReport.setUniqueUsers(repository.getUniqueUsersNW(reportInput));

		metricsReport.setUniqueProviders(repository.getUniqueProviders(reportInput));

		metricsReport.setUniqueProviders(repository.getUniqueProvidersNW(reportInput));

		metricsReport.setUniqueMembers(repository.getUniqueMembers(reportInput));

		metricsReport.setUniqueMembers(repository.getUniqueMembersNW(reportInput));

		metricsReport.setSourceTypes(repository.getSourceTypes(reportInput));

		metricsReport.setSourceTypes(repository.getSourceTypesNW(reportInput));

		metricsReport.setResponseTypes(repository.getResponseTypes(reportInput));

		metricsReport.setResponseTypes(repository.getResponseTypesNW(reportInput));

		metricsReport.setTotalResponseTypes(repository.getTotalResponseTypes(reportInput));

		metricsReport.setTotalResponseTypes(repository.getTotalResponseTypesNW(reportInput));

		metricsReport.setResponseAndSourceTypes(repository.getResponseAndSourceTypes(reportInput));

		metricsReport.setResponseAndSourceTypes(repository.getResponseAndSourceTypesNW(reportInput));

		metricsReport.setTop7Gaps(repository.getTop7GapsFL(reportInput));

		metricsReport.setTop7Gaps(repository.getTop7GapsIN(reportInput));

		metricsReport.setTop7Gaps(repository.getTop7GapsNY(reportInput));

		metricsReport.setTop7Gaps(repository.getTop7GapsOH(reportInput));

		metricsReport.setTop7Gaps(repository.getTop7GapsAooleCare(reportInput));

		metricsReport.setTop7Gaps(repository.getTop7GapsCAStandalone(reportInput));

		metricsReport.setTop7Gaps(repository.getTop7GapsCAIntegrated(reportInput));

		metricsReport.setTop7Gaps(repository.getTop7GapsNW(reportInput));

		metricsReport.setTop7Gaps(repository.getTop7GapsOR(reportInput));

		metricsReport.setPatientProviders(repository.getPatientProvidersCAStandalone(reportInput));
		metricsReport.setPatientProviders(repository.getPatientProvidersStandalone(reportInput));

		metricsReport.setPatientProviders(repository.getPatientProvidersIntegrated(reportInput));

		metricsReport.setPatientProviders(repository.getPatientProvidersNW(reportInput));

		return metricsReport;
	}

	@Override
	public String generateExcelFile(MetricsReport mr, ReportInput reportInput) {

		return fileService.generateExcelFile(mr, reportInput);

	}

	@Override
	public ClinicalChartReport getclinicalChartReport(ReportInput reportInput) {

		ClinicalChartReport report = new ClinicalChartReport();

		List<FileInfo> fileinfo = clinicalChartRepository.getFileInfo(reportInput);
		logger.info(fileinfo.size() + " list of files");

		List<String> personIds = fileinfo.stream().map(FileInfo::getPersonID).distinct().collect(Collectors.toList());
		logger.info(personIds.size() + " list of distinct patients ");

		List<PatientGapsInfo> gapslist = clinicalChartRepository
				.getGapsInfo(fileinfo.stream().map(FileInfo::getId).distinct().collect(Collectors.toList()));

		List<PatientInfo> pList = clinicalChartRepository.getPatientInfo(personIds, reportInput);
		logger.info(pList.size() + " patients list ");

		Set<PatientInfo> patientinfo = new HashSet<PatientInfo>(pList);
		logger.info(patientinfo.size() + " list of distinct patients ");

		List<MemberInfo> mlist = clinicalChartRepository.getMemberInfo(personIds);
		logger.info(mlist.size() + " list of members info");

		Set<MemberInfo> memberInfo = new HashSet<MemberInfo>(mlist);
		logger.info(memberInfo.size() + " list of distinct members info");

		List<ClinicalChart> chartList = new ArrayList<ClinicalChart>();

		// Map<FileInfo, List<PatientInfo>> updateTimeNotMatched = new
		// HashedMap<FileInfo, List<PatientInfo>>();
		Map<FileInfo, List<PatientInfo>> multipleDOS = new HashedMap<FileInfo, List<PatientInfo>>();
		// Map<FileInfo, List<PatientInfo>> updateTimeMatched = new HashedMap<FileInfo,
		// List<PatientInfo>>();
		// Map<FileInfo, List<PatientInfo>> refDateMatched = new HashedMap<FileInfo,
		// List<PatientInfo>>();
		// Map<FileInfo, List<PatientInfo>> refDateAndUpdateTimeMatched = new
		// HashedMap<FileInfo, List<PatientInfo>>();
		List<FileInfo> noGaps = new ArrayList<>();
		List<FileInfo> noAttestations = new ArrayList<>();

		for (FileInfo file : fileinfo) {

			List<PatientGapsInfo> gaps = gapslist.stream().filter(c -> c.getId() == file.getId())
					.collect(Collectors.toList());

			MemberInfo minfo = memberInfo.stream().filter(c -> c.getPersonID().equals(file.getPersonID())).findAny()
					.orElse(new MemberInfo());

			ClinicalChart chart = new ClinicalChart();

			if (gaps.size() == 0) {
				noGaps.add(file);
				Optional<PatientInfo> pinfo = patientinfo.stream()
						.filter(c -> c.getPersonID().equals(file.getPersonID())).findFirst();

				if (pinfo.isPresent()) {

					chart = fillClinicalChart(minfo, file, pinfo.get());
				} else {
					noAttestations.add(file);
					chart = fillClinicalChart(minfo, file,
							new PatientInfo(minfo.getEntity(), minfo.getPersonID(), minfo.getFirstName(),
									minfo.getLastName(), minfo.getDob(), null, null, null, null, null, null));
				}

				chartList.add(chart);

			} else {

				List<PatientInfo> plist2 = new ArrayList<PatientInfo>();

				for (PatientGapsInfo gap : gaps) {

					List<PatientInfo> list = patientinfo.stream()
							.filter(c -> c.getPersonID().equals(file.getPersonID())
									&& c.getHccCode().equals(gap.getHcc().substring(3).trim())
									&& c.getIccCode().equals(gap.getIcc()))
							.collect(Collectors.toList());

					if (list != null && list.size() > 0) {

						List<PatientInfo> list2 = list.stream().filter(c -> c.getRefDate().equals(gap.getRefDate()))
								.collect(Collectors.toList());

						if (list2 != null && list2.size() > 0) {
							plist2.addAll(list2);
						} else {
							plist2.addAll(list);
						}
					}

				}

				if (plist2 == null || plist2.size() == 0) {
					noAttestations.add(file);

					Optional<PatientInfo> pinfo = patientinfo.stream()
							.filter(c -> c.getPersonID().equals(file.getPersonID())).findFirst();

					if (pinfo.isPresent()) {

						chart = fillClinicalChart(minfo, file, pinfo.get());
					} else {

						chart = fillClinicalChart(minfo, file,
								new PatientInfo(minfo.getEntity(), minfo.getPersonID(), minfo.getFirstName(),
										minfo.getLastName(), minfo.getDob(), null, null, null, null, null, null));
					}

					chartList.add(chart);

				} else {

					multipleDOS.put(file, plist2);

					List<Date> dosList = plist2.stream().map(c -> c.getDos()).distinct().collect(Collectors.toList());

					PatientInfo pinfo = plist2.stream().filter(c -> c.getPersonID().equals(file.getPersonID()))
							.findFirst().get();

					for (Date dos : dosList) {

						chart = fillClinicalChart(minfo, file, pinfo, dos);
						chartList.add(chart);
					}

				}

			}

		}

		logger.info(noGaps.size() + " number of docs with out gaps ");
		logger.info(noAttestations.size() + " number of docs with out attestations ");
		docReport.collectDocuments(noGaps, "noGapsFound");
		docReport.collectDocuments(noAttestations, "noAttestationsFound");
		// docReport.prepareDocumnetReport(updateTimeNotMatched,
		// "updateTimeNotMatched");
		docReport.prepareDocumnetReport(multipleDOS, "multipleDos");
		// docReport.prepareDocumnetReport(updateTimeMatched, "updateTimeMatched");
		// docReport.prepareDocumnetReport(refDateMatched, "refDateMatched");
		// docReport.prepareDocumnetReport(refDateAndUpdateTimeMatched,
		// "refDateAndUpdateTimeMatched");
		report.setClinicalCharts(chartList);

		return report;
	}

	@Override
	public String generateClinicalChartReportExcelFile(ClinicalChartReport clinicalReport, ReportInput reportInput) {

		return clinicalFileService.generateClinicalChartReportExcelFile(clinicalReport, reportInput);
	}

	private ClinicalChart fillClinicalChart(MemberInfo minfo, FileInfo file, PatientInfo pinfo) {

		ClinicalChart chart = new ClinicalChart();

		chart.setFileName(file.getFileName());
		chart.setGmpi(minfo.getGmpi());
		chart.setSubscriberID(minfo.getSubscriberID());
		chart.setFirstName(pinfo.getFirstName());
		chart.setLastName(pinfo.getLastNAme());
		chart.setDob(pinfo.getDob());
		chart.setDos(null);
		chart.setSubmittedDate(file.getUpdateDtm());
		chart.setEntity(pinfo.getEntity());

		return chart;
	}

	private ClinicalChart fillClinicalChart(MemberInfo minfo, FileInfo file, PatientInfo pinfo, Date dos) {

		ClinicalChart chart = new ClinicalChart();

		chart.setFileName(file.getFileName());
		chart.setGmpi(minfo.getGmpi());
		chart.setSubscriberID(minfo.getSubscriberID());
		chart.setFirstName(pinfo.getFirstName());
		chart.setLastName(pinfo.getLastNAme());
		chart.setDob(pinfo.getDob());
		chart.setDos(dos);
		chart.setSubmittedDate(file.getUpdateDtm());
		chart.setEntity(pinfo.getEntity());

		return chart;
	}
}
