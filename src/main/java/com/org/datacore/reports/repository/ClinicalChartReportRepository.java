package com.org.datacore.reports.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.datacore.reports.model.ReportInput;
import com.org.datacore.reports.clinical.model.*;

@Repository
public class ClinicalChartReportRepository {

	@Autowired
	@Qualifier("namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	@Qualifier("namedParameterJdbcTemplateTwo")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplateTwo;

	public List<FileInfo> getFileInfo(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplateTwo.query(FILE_INFO, mapSqlParameterSource,
				(rs, rowNum) -> new FileInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getDate(5), rs.getString(6)));
	}

	public List<PatientInfo> getPatientInfo(List<String> pids, ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("pids", pids);
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(PATIENT_INFO, mapSqlParameterSource,
				(rs, rowNum) -> new PatientInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10),
						rs.getDate(11)));
	}

	public List<MemberInfo> getMemberInfo(List<String> personIds) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("ids", personIds);

		return namedParameterJdbcTemplate.query(MEMBER_INFO, mapSqlParameterSource,
				(rs, rowNum) -> new MemberInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getString(7)));
	}

	public List<PatientGapsInfo> getGapsInfo(List<Integer> ids) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("taxIds", ids);

		return namedParameterJdbcTemplateTwo.query(GAPS_INFO, mapSqlParameterSource,
				(rs, rowNum) -> new PatientGapsInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));

	}

	public static final String FILE_INFO = "select id, fileName, personId,   updateDateTime, createDateTime, state \r\n"
			+ "from datacoredoc_01.doc_taxonomy \r\n" + "where fileName is not null  \r\n"
			+ "and updateDateTime between :startDate and :endDate \r\n" + "order by fileName desc";

	public static final String PATIENT_INFO = "select  e.name, p.PersonId, p.FirstName,p.LastName,p.DateOfBirth, a.ResponseDate,  a.HccCode, a.IcdCode, a.Status, a.UpdateDttm, a.RefDate \r\n"
			+ "from  dtcr01.attestation a, dtcr01.gbl_person p, dtcr01.gbl_applicationtype t, dtcr01.gbl_entity e\r\n"
			+ "where p.PersonId = a.PersonId\r\n" + "and t.ApplicationTypeId = a.ApplicationTypeId\r\n"
			+ "and t.ApplicationTypeId = \"0a2a866a-9074-11ea-ad18-005056b78696\"\r\n"
			+ "and e.EntityId = a.EntityId and Date(a.UpdateDttm) between :startDate and :endDate and a.PersonId in ( :pids ) ";

	public static final String MEMBER_INFO = "select distinct gp.PersonId, bms.GMPI,bms.SubscriberId, gp.FirstName,gp.LastName,gp.DateOfBirth, ge.Name\r\n"
			+ "from dtcr01.attestation att\r\n" + "join dtcr01.gbl_memberidentity gmi\r\n"
			+ "on att.PersonId = gmi.Personid\r\n" + "join dtcr01.btch_membersummary bms\r\n"
			+ "on bms.AlternateId = SUBSTRING(gmi.SystemIdValue, 1, 10)\r\n" + "join dtcr01.gbl_person gp \r\n"
			+ "on gp.PersonId = gmi.PersonId\r\n" + "join dtcr01.gbl_entity ge\r\n"
			+ "on att.EntityId = ge.EntityId\r\n"
			+ "where att.ApplicationTypeId = '0a2a866a-9074-11ea-ad18-005056b78696'\r\n"
			+ "and gp.PersonId in ( :ids )";

	public static final String GAPS_INFO = "select g.docTaxonomyId, g.hcc, g.icd, g.refDate from datacoredoc_01.doc_taxonomy_gap g where docTaxonomyId in ( :taxIds ) ";

}
