package com.org.datacore.reports.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.org.datacore.reports.model.PatientProvider;
import com.org.datacore.reports.model.ReportInput;
import com.org.datacore.reports.model.ResponseAndSourceType;
import com.org.datacore.reports.model.ResponseType;
import com.org.datacore.reports.model.SourceType;
import com.org.datacore.reports.model.Top7Gaps;
import com.org.datacore.reports.model.TotalResponseType;
import com.org.datacore.reports.model.UniqueMember;
import com.org.datacore.reports.model.UniqueProvider;
import com.org.datacore.reports.model.UniqueUser;
import com.org.datacore.reports.util.Constants;

@Repository
public class MetricsReportRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<UniqueUser> getUniqueUsers(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.UNIQUE_USERS, mapSqlParameterSource,
				(rs, rowNum) -> new UniqueUser(rs.getString(1), rs.getString(2), rs.getInt(3)));
	}

	public List<UniqueUser> getUniqueUsersNW(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.UNIQUE_USERS_NEWWEST, mapSqlParameterSource,
				(rs, rowNum) -> new UniqueUser(rs.getString(1), rs.getString(2), rs.getInt(3)));
	}

	public List<UniqueProvider> getUniqueProviders(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.UNIQUE_PROVIDERS, mapSqlParameterSource,
				(rs, rowNum) -> new UniqueProvider(rs.getString(1), rs.getString(2), rs.getInt(3)));
	}

	public List<UniqueProvider> getUniqueProvidersNW(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.UNIQUE_PROVIDERS_NEWWEST, mapSqlParameterSource,
				(rs, rowNum) -> new UniqueProvider(rs.getString(1), rs.getString(2), rs.getInt(3)));
	}

	public List<UniqueMember> getUniqueMembers(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.UNIQUE_MEMBERS, mapSqlParameterSource,
				(rs, rowNum) -> new UniqueMember(rs.getString(1), rs.getString(2), rs.getInt(3)));
	}

	public List<UniqueMember> getUniqueMembersNW(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.UNIQUE_MEMBERS_NEWWEST, mapSqlParameterSource,
				(rs, rowNum) -> new UniqueMember(rs.getString(1), rs.getString(2), rs.getInt(3)));
	}

	public List<SourceType> getSourceTypes(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.SOURCE_TYPE_COUNTS, mapSqlParameterSource,
				(rs, rowNum) -> new SourceType(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
	}

	public List<SourceType> getSourceTypesNW(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.SOURCE_TYPE_COUNTS_NEWWEST, mapSqlParameterSource,
				(rs, rowNum) -> new SourceType(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
	}

	public List<ResponseType> getResponseTypes(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.RESPONSE_TYPE_COUNTS, mapSqlParameterSource,
				(rs, rowNum) -> new ResponseType(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
	}

	public List<ResponseType> getResponseTypesNW(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.RESPONSE_TYPE_COUNTS_NEWWEST, mapSqlParameterSource,
				(rs, rowNum) -> new ResponseType(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
	}

	public List<TotalResponseType> getTotalResponseTypes(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOTAL_RESPONSE_TYPE_COUNTS, mapSqlParameterSource,
				(rs, rowNum) -> new TotalResponseType(rs.getString(1), rs.getString(2), rs.getInt(3)));
	}

	public List<TotalResponseType> getTotalResponseTypesNW(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOTAL_RESPONSE_TYPE_COUNTS_NEWWEST, mapSqlParameterSource,
				(rs, rowNum) -> new TotalResponseType(rs.getString(1), rs.getString(2), rs.getInt(3)));
	}

	public List<ResponseAndSourceType> getResponseAndSourceTypes(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.RESPONSE_AND_SOURCE_TYPE_COUNTS, mapSqlParameterSource,
				(rs, rowNum) -> new ResponseAndSourceType(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5)));
	}

	public List<ResponseAndSourceType> getResponseAndSourceTypesNW(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.RESPONSE_AND_SOURCE_TYPE_COUNTS_NEWWEST,
				mapSqlParameterSource, (rs, rowNum) -> new ResponseAndSourceType(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5)));
	}

	public List<Top7Gaps> getTop7GapsFL(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOPGAPSFL, mapSqlParameterSource,
				(rs, rowNum) -> new Top7Gaps(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
	}

	public List<Top7Gaps> getTop7GapsIN(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOPGAPSIN, mapSqlParameterSource,
				(rs, rowNum) -> new Top7Gaps(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
	}

	public List<Top7Gaps> getTop7GapsNY(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOPGAPSNY, mapSqlParameterSource,
				(rs, rowNum) -> new Top7Gaps(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
	}

	public List<Top7Gaps> getTop7GapsOH(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOPGAPSOH, mapSqlParameterSource,
				(rs, rowNum) -> new Top7Gaps(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
	}
	
	public List<Top7Gaps> getTop7GapsAooleCare(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOPGAPSAPPLECARE, mapSqlParameterSource,
				(rs, rowNum) -> new Top7Gaps(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
	}

	public List<Top7Gaps> getTop7GapsCAStandalone(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOPGAPS_CA_SATNDALONE, mapSqlParameterSource,
				(rs, rowNum) -> new Top7Gaps(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
	}

	public List<Top7Gaps> getTop7GapsCAIntegrated(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOPGAPS_CA_INTEGRATED, mapSqlParameterSource,
				(rs, rowNum) -> new Top7Gaps(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
	}

	public List<Top7Gaps> getTop7GapsNW(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOPGAPSNW, mapSqlParameterSource,
				(rs, rowNum) -> new Top7Gaps(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
	}

	public List<Top7Gaps> getTop7GapsOR(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.TOPGAPSOR, mapSqlParameterSource,
				(rs, rowNum) -> new Top7Gaps(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
	}

	public List<PatientProvider> getPatientProvidersCAStandalone(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.PATIENT_PROVIDER_REPORT_CA_STANDALONE, mapSqlParameterSource,
				(rs, rowNum) -> new PatientProvider(String.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDate(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)

				));
	}
	
	public List<PatientProvider> getPatientProvidersStandalone(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.PATIENT_PROVIDER_REPORT_STANDALONE, mapSqlParameterSource,
				(rs, rowNum) -> new PatientProvider(String.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDate(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)

				));
	}

	public List<PatientProvider> getPatientProvidersIntegrated(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.PATIENT_PROVIDER_REPORT_INTEGRATED, mapSqlParameterSource,
				(rs, rowNum) -> new PatientProvider(String.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), "",
						rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)

				));
	}

	public List<PatientProvider> getPatientProvidersNW(ReportInput reportInput) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("startDate", reportInput.getStartDate());
		mapSqlParameterSource.addValue("endDate", reportInput.getEndDate());

		return namedParameterJdbcTemplate.query(Constants.PATIENT_PROVIDER_REPORT_NW, mapSqlParameterSource,
				(rs, rowNum) -> new PatientProvider(rs.getString(1), rs.getString(2), rs.getString(3), "",
						rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)

				));
	}

}
