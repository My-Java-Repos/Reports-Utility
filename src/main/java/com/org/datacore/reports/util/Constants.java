package com.org.datacore.reports.util;

public class Constants {

	public static final String UNIQUE_USERS = "select ge.Name , ga.`Type` , count(distinct a.UpdateUser ) as count\r\n"
			+ "from dtcr01.attestation a , dtcr01.gbl_user gu , dtcr01.gbl_entity ge ,\r\n"
			+ "dtcr01.gbl_applicationtype ga , dtcr01.gbl_usersystemidentity gu4\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate \r\n" + "and a.UpdateUser = gu.UserId\r\n"
			+ "and gu.UserId = gu4.UserId\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "group by ge.Name , ga.`Type`\r\n"
			+ "order by ge.Name, ga.`Type` ";

	public static final String UNIQUE_USERS_NEWWEST = "select ge.Name , ga.`Type` , count(distinct a.UpdateUser ) as count\r\n"
			+ "from dtcr01.dc_trans_hcc_attestation a , dtcr01.gbl_user gu , dtcr01.gbl_entity ge , dtcr01.gbl_applicationtype ga , dtcr01.gbl_usersystemidentity gu4\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n" + "and a.UpdateUser = gu.UserId\r\n"
			+ "and gu.UserId = gu4.UserId\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.EntityId = '6be074ff-c02b-4b84-a3ae-ef2c6ccbc950'\r\n"
			+ "and ga.ApplicationTypeId = 'b91fa1ef-9074-11ea-ad18-005056b78696'";

	public static final String UNIQUE_PROVIDERS = "select ge.Name , ga.`Type` , count(distinct a.Npi ) as count\r\n"
			+ "from dtcr01.attestation a , dtcr01.gbl_user gu , dtcr01.gbl_entity ge ,\r\n"
			+ "dtcr01.gbl_applicationtype ga , dtcr01.gbl_usersystemidentity gu4\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n" + "and a.UpdateUser = gu.UserId\r\n"
			+ "and gu.UserId = gu4.UserId\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "group by ge.Name , ga.`Type`\r\n"
			+ "order by ge.Name, ga.`Type`";

	public static final String UNIQUE_PROVIDERS_NEWWEST = "select ge.Name , ga.`Type` , count(distinct a.UserId ) as count\r\n"
			+ "from dtcr01.dc_trans_hcc_attestation a , dtcr01.gbl_user gu , dtcr01.gbl_entity ge ,\r\n"
			+ "dtcr01.gbl_applicationtype ga , dtcr01.gbl_usersystemidentity gu4\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n" + "and a.UpdateUser = gu.UserId\r\n"
			+ "and gu.UserId = gu4.UserId\r\n" + "and a.EntityId = '6be074ff-c02b-4b84-a3ae-ef2c6ccbc950'\r\n"
			+ "and a.EntityId = ge.EntityId\r\n" + "and ga.ApplicationTypeId = 'b91fa1ef-9074-11ea-ad18-005056b78696' ";

	public static final String UNIQUE_MEMBERS = "select ge.name, ga.`Type` , count( distinct gp.PersonId) as count\r\n"
			+ "from dtcr01.attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_person gp\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n" + "and a.UpdateUser = gu2.UserId\r\n"
			+ "and gu.UserId = gu2.UserId\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and gp.PersonId = a.PersonId\r\n"
			+ "group by ge.Name, ga.`Type`";

	public static final String UNIQUE_MEMBERS_NEWWEST = "select ge.name, ga.`Type` , count( distinct gp.PersonId) as count\r\n"
			+ "from dtcr01.dc_trans_hcc_attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_person gp\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n" + "and a.UpdateUser = gu2.UserId\r\n"
			+ "and gu.UserId = gu2.UserId\r\n" + "and a.EntityId = '6be074ff-c02b-4b84-a3ae-ef2c6ccbc950'\r\n"
			+ "and a.EntityId = ge.EntityId\r\n"
			+ "and ga.ApplicationTypeId = 'b91fa1ef-9074-11ea-ad18-005056b78696'\r\n"
			+ "and gp.PersonId = a.MemberId\r\n" + "group by ge.Name, ga.`Type`";

	public static final String SOURCE_TYPE_COUNTS = "select ge.name, ga.`Type`, SourceType, count(SourceType) as count\r\n"
			+ "from dtcr01.attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_person gp\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n" + "and gu.UserId = gu2.UserId\r\n"
			+ "and a.EntityId = ge.EntityId\r\n" + "and a.UpdateUser = gu2.UserId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and gp.PersonId = a.PersonId\r\n"
			+ "group by SourceType , ge.Name, ga.`Type`\r\n" + "order by ga.`Type`, ge.Name , SourceType";

	public static final String SOURCE_TYPE_COUNTS_NEWWEST = "select ge.name, ga.`Type`, SourceType, count(SourceType) as count\r\n"
			+ "from dtcr01.dc_trans_hcc_attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_person gp\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n" + "and gu.UserId = gu2.UserId\r\n"
			+ "and a.EntityId = '6be074ff-c02b-4b84-a3ae-ef2c6ccbc950'\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.UpdateUser = gu2.UserId\r\n"
			+ "and ga.ApplicationTypeId = 'b91fa1ef-9074-11ea-ad18-005056b78696'\r\n"
			+ "and gp.PersonId = a.MemberId\r\n" + "group by SourceType , ge.Name, ga.`Type`\r\n"
			+ "order by ga.`Type`, ge.Name , SourceType ";

	public static final String RESPONSE_TYPE_COUNTS = "select ge.name, ga.`Type` , ResponseType, count(ResponseType) as count\r\n"
			+ "from dtcr01.attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_person gp\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n"
			+ "and gu.UserId = gu2.UserId and a.EntityId = ge.EntityId\r\n" + "and a.UpdateUser = gu2.UserId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and gp.PersonId = a.PersonId\r\n"
			+ "group by ge.Name , ga.`Type` , ResponseType\r\n" + "order by ge.Name , ga.`Type`, ResponseType ";

	public static final String RESPONSE_TYPE_COUNTS_NEWWEST = "select ge.name, ga.`Type` , ResponseType, count(ResponseType) as count\r\n"
			+ "from dtcr01.dc_trans_hcc_attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_person gp\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n" + "and gu.UserId = gu2.UserId\r\n"
			+ "and a.EntityId = '6be074ff-c02b-4b84-a3ae-ef2c6ccbc950'\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.UpdateUser = gu2.UserId\r\n"
			+ "and ga.ApplicationTypeId = 'b91fa1ef-9074-11ea-ad18-005056b78696'\r\n"
			+ "and gp.PersonId = a.MemberId\r\n" + "group by ge.Name , ga.`Type` , ResponseType\r\n"
			+ "order by ge.Name , ga.`Type`, ResponseType";

	public static final String TOTAL_RESPONSE_TYPE_COUNTS = "select ge.name, ga.`Type`, count(ResponseType) as count\r\n"
			+ "from dtcr01.attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_person gp\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n"
			+ "and gu.UserId = gu2.UserId and a.EntityId = ge.EntityId\r\n" + "and a.UpdateUser = gu2.UserId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and gp.PersonId = a.PersonId\r\n"
			+ "group by ge.Name , ga.`Type`\r\n" + "order by ge.Name , ga.`Type`";

	public static final String TOTAL_RESPONSE_TYPE_COUNTS_NEWWEST = "select ge.name, ga.`Type`, count(ResponseType) as count\r\n"
			+ "from dtcr01.dc_trans_hcc_attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_person gp\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n" + "and gu.UserId = gu2.UserId\r\n"
			+ "and a.EntityId = '6be074ff-c02b-4b84-a3ae-ef2c6ccbc950'\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.UpdateUser = gu2.UserId\r\n"
			+ "and ga.ApplicationTypeId = 'b91fa1ef-9074-11ea-ad18-005056b78696'\r\n"
			+ "and gp.PersonId = a.MemberId\r\n" + "group by ge.Name , ga.`Type`\r\n" + "order by ge.Name , ga.`Type`";

	public static final String RESPONSE_AND_SOURCE_TYPE_COUNTS = "select ge.name, ga.`Type` , ResponseType , SourceType, count(*) as count\r\n"
			+ "from dtcr01.attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_person gp\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n"
			+ "and gu.UserId = gu2.UserId and a.EntityId = ge.EntityId\r\n" + "and a.UpdateUser = gu2.UserId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and gp.PersonId = a.PersonId\r\n"
			+ "group by ge.Name , ga.`Type` , ResponseType , SourceType\r\n"
			+ "order by ge.Name , ResponseType, ga.`Type`	";

	public static final String RESPONSE_AND_SOURCE_TYPE_COUNTS_NEWWEST = "select ge.name, ga.`Type` , ResponseType , SourceType, count(*) as count\r\n"
			+ "from dtcr01.dc_trans_hcc_attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_person gp\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate  \r\n" + "and gu.UserId = gu2.UserId\r\n"
			+ "and a.EntityId = '6be074ff-c02b-4b84-a3ae-ef2c6ccbc950'\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.UpdateUser = gu2.UserId\r\n"
			+ "and ga.ApplicationTypeId = 'b91fa1ef-9074-11ea-ad18-005056b78696'\r\n"
			+ "and gp.PersonId = a.MemberId\r\n" + "group by ge.Name , ga.`Type` , ResponseType , SourceType\r\n"
			+ "order by ge.Name , ResponseType, ga.`Type`";

	public static final String TOPGAPSFL = "select name, Type, HccCode, RecaptureCount,SuspectCount, InsufficientCount, CmsSuspectCount, \r\n"
			+ "SUM(CmsSuspectCount+InsufficientCount+SuspectCount + RecaptureCount) as total \r\n"
			+ "from (select ge.name, ga.`Type`, a.HccCode,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'RECAPTURE' THEN 1 ELSE 0 END) AS RecaptureCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'SUSPECT' THEN 1 ELSE 0 END) AS SuspectCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'INSUFFICIENT' THEN 1 ELSE 0 END) AS InsufficientCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'CMS_SUSPECT' THEN 1 ELSE 0 END) AS CmsSuspectCount\r\n"
			+ "from dtcr01.attestation a , dtcr01.gbl_entity ge, dtcr01.gbl_applicationtype ga\r\n"
			+ "where Date(a.UpdateDttm)  between :startDate and :endDate\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and ge.name = 'HCPFL'\r\n"
			+ "group by ge.Name , ga.`Type`, a.HccCode   ) as T\r\n" + "group by name, Type, HccCode\r\n"
			+ "order by total desc\r\n" + "limit 7";

	public static final String TOPGAPSIN = "select name, Type, HccCode, RecaptureCount,SuspectCount, InsufficientCount, CmsSuspectCount, \r\n"
			+ "SUM(CmsSuspectCount+InsufficientCount+SuspectCount + RecaptureCount) as total \r\n"
			+ "from (select ge.name, ga.`Type`, a.HccCode,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'RECAPTURE' THEN 1 ELSE 0 END) AS RecaptureCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'SUSPECT' THEN 1 ELSE 0 END) AS SuspectCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'INSUFFICIENT' THEN 1 ELSE 0 END) AS InsufficientCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'CMS_SUSPECT' THEN 1 ELSE 0 END) AS CmsSuspectCount\r\n"
			+ "from dtcr01.attestation a , dtcr01.gbl_entity ge, dtcr01.gbl_applicationtype ga\r\n"
			+ "where Date(a.UpdateDttm)  between :startDate and :endDate\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and ge.name = 'OCN-IN'\r\n"
			+ "group by ge.Name , ga.`Type`, a.HccCode   ) as T\r\n" + "group by name, Type, HccCode\r\n"
			+ "order by total desc\r\n" + "limit 7";

	public static final String TOPGAPSNY = "select name, Type, HccCode, RecaptureCount,SuspectCount, InsufficientCount, CmsSuspectCount, \r\n"
			+ "SUM(CmsSuspectCount+InsufficientCount+SuspectCount + RecaptureCount) as total \r\n"
			+ "from (select ge.name, ga.`Type`, a.HccCode,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'RECAPTURE' THEN 1 ELSE 0 END) AS RecaptureCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'SUSPECT' THEN 1 ELSE 0 END) AS SuspectCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'INSUFFICIENT' THEN 1 ELSE 0 END) AS InsufficientCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'CMS_SUSPECT' THEN 1 ELSE 0 END) AS CmsSuspectCount\r\n"
			+ "from dtcr01.attestation a , dtcr01.gbl_entity ge, dtcr01.gbl_applicationtype ga\r\n"
			+ "where Date(a.UpdateDttm)  between :startDate and :endDate\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and ge.name = 'OCN-NY'\r\n"
			+ "group by ge.Name , ga.`Type`, a.HccCode   ) as T\r\n" + "group by name, Type, HccCode\r\n"
			+ "order by total desc\r\n" + "limit 7";

	public static final String TOPGAPSOH = "select name, Type, HccCode, RecaptureCount,SuspectCount, InsufficientCount, CmsSuspectCount, \r\n"
			+ "SUM(CmsSuspectCount+InsufficientCount+SuspectCount + RecaptureCount) as total \r\n"
			+ "from (select ge.name, ga.`Type`, a.HccCode,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'RECAPTURE' THEN 1 ELSE 0 END) AS RecaptureCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'SUSPECT' THEN 1 ELSE 0 END) AS SuspectCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'INSUFFICIENT' THEN 1 ELSE 0 END) AS InsufficientCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'CMS_SUSPECT' THEN 1 ELSE 0 END) AS CmsSuspectCount\r\n"
			+ "from dtcr01.attestation a , dtcr01.gbl_entity ge, dtcr01.gbl_applicationtype ga\r\n"
			+ "where Date(a.UpdateDttm)  between :startDate and :endDate\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and ge.name = 'OCN-OH'\r\n"
			+ "group by ge.Name , ga.`Type`, a.HccCode   ) as T\r\n" + "group by name, Type, HccCode\r\n"
			+ "order by total desc\r\n" + "limit 7";

	public static final String TOPGAPS_CA_SATNDALONE = "select name, Type, HccCode, RecaptureCount,SuspectCount, InsufficientCount, CmsSuspectCount, \r\n"
			+ "SUM(CmsSuspectCount+InsufficientCount+SuspectCount + RecaptureCount) as total \r\n"
			+ "from (select ge.name, ga.`Type`, a.HccCode,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'RECAPTURE' THEN 1 ELSE 0 END) AS RecaptureCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'SUSPECT' THEN 1 ELSE 0 END) AS SuspectCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'INSUFFICIENT' THEN 1 ELSE 0 END) AS InsufficientCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'CMS_SUSPECT' THEN 1 ELSE 0 END) AS CmsSuspectCount\r\n"
			+ "from dtcr01.attestation a , dtcr01.gbl_entity ge, dtcr01.gbl_applicationtype ga\r\n"
			+ "where Date(a.UpdateDttm)  between :startDate and :endDate\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and ga.`Type` = 'DatacoreStandalone'\r\n"
			+ "and ge.name = 'HCPCA'\r\n" + "group by ge.Name , ga.`Type`, a.HccCode   ) as T\r\n"
			+ "group by name, Type, HccCode\r\n" + "order by total desc\r\n" + "limit 7";

	public static final String TOPGAPS_CA_INTEGRATED = "select name, Type, HccCode, RecaptureCount,SuspectCount, InsufficientCount, CmsSuspectCount, \r\n"
			+ "SUM(CmsSuspectCount+InsufficientCount+SuspectCount + RecaptureCount) as total \r\n"
			+ "from (select ge.name, ga.`Type`, a.HccCode,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'RECAPTURE' THEN 1 ELSE 0 END) AS RecaptureCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'SUSPECT' THEN 1 ELSE 0 END) AS SuspectCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'INSUFFICIENT' THEN 1 ELSE 0 END) AS InsufficientCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'CMS_SUSPECT' THEN 1 ELSE 0 END) AS CmsSuspectCount\r\n"
			+ "from dtcr01.attestation a , dtcr01.gbl_entity ge, dtcr01.gbl_applicationtype ga\r\n"
			+ "where Date(a.UpdateDttm)  between :startDate and :endDate\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and ga.`Type` = 'DatacoreIntegrated'\r\n"
			+ "and ge.name = 'HCPCA'\r\n" + "group by ge.Name , ga.`Type`, a.HccCode   ) as T\r\n"
			+ "group by name, Type, HccCode\r\n" + "order by total desc\r\n" + "limit 7";

	public static final String TOPGAPSNW = "select name, Type, HccCode, RecaptureCount,SuspectCount, InsufficientCount, CmsSuspectCount, \r\n"
			+ "SUM(CmsSuspectCount+InsufficientCount+SuspectCount + RecaptureCount) as total \r\n"
			+ "from (select ge.name, ga.`Type`, a.HccCode,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'RECAPTURE' THEN 1 ELSE 0 END) AS RecaptureCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'SUSPECT' THEN 1 ELSE 0 END) AS SuspectCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'INSUFFICIENT' THEN 1 ELSE 0 END) AS InsufficientCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'CMS_SUSPECT' THEN 1 ELSE 0 END) AS CmsSuspectCount\r\n"
			+ "from dtcr01.dc_trans_hcc_attestation a , dtcr01.gbl_entity ge, dtcr01.gbl_applicationtype ga\r\n"
			+ "where Date(a.UpdateDttm)  between :startDate and :endDate\r\n"
			+ "and a.EntityId = '6be074ff-c02b-4b84-a3ae-ef2c6ccbc950'\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and ga.ApplicationTypeId = 'b91fa1ef-9074-11ea-ad18-005056b78696'\r\n"
			+ "group by ge.Name , ga.`Type`, a.HccCode   ) as T\r\n" + "group by name, Type, HccCode\r\n"
			+ "order by total desc\r\n" + "limit 7";

	public static final String TOPGAPSOR = "select name, Type, HccCode, RecaptureCount,SuspectCount, InsufficientCount, CmsSuspectCount, \r\n"
			+ "SUM(CmsSuspectCount+InsufficientCount+SuspectCount + RecaptureCount) as total \r\n"
			+ "from (select ge.name, ga.`Type`, a.HccCode,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'RECAPTURE' THEN 1 ELSE 0 END) AS RecaptureCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'SUSPECT' THEN 1 ELSE 0 END) AS SuspectCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'INSUFFICIENT' THEN 1 ELSE 0 END) AS InsufficientCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'CMS_SUSPECT' THEN 1 ELSE 0 END) AS CmsSuspectCount\r\n"
			+ "from dtcr01.attestation a , dtcr01.gbl_entity ge, dtcr01.gbl_applicationtype ga\r\n"
			+ "where Date(a.UpdateDttm)  between :startDate and :endDate\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and ge.name = 'OCN-OR'\r\n"
			+ "group by ge.Name , ga.`Type`, a.HccCode   ) as T\r\n" + "group by name, Type, HccCode\r\n"
			+ "order by total desc\r\n" + "limit 7";

	public static final String TOPGAPSAPPLECARE = "select name, Type, HccCode, RecaptureCount,SuspectCount, InsufficientCount, CmsSuspectCount, \r\n"
			+ "SUM(CmsSuspectCount+InsufficientCount+SuspectCount + RecaptureCount) as total \r\n"
			+ "from (select ge.name, ga.`Type`, a.HccCode,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'RECAPTURE' THEN 1 ELSE 0 END) AS RecaptureCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'SUSPECT' THEN 1 ELSE 0 END) AS SuspectCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'INSUFFICIENT' THEN 1 ELSE 0 END) AS InsufficientCount,\r\n"
			+ "SUM(CASE a.SourceCode WHEN 'CMS_SUSPECT' THEN 1 ELSE 0 END) AS CmsSuspectCount\r\n"
			+ "from dtcr01.attestation a , dtcr01.gbl_entity ge, dtcr01.gbl_applicationtype ga\r\n"
			+ "where Date(a.UpdateDttm)  between :startDate and :endDate\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and ge.name = 'AppleCare'\r\n"
			+ "group by ge.Name , ga.`Type`, a.HccCode   ) as T\r\n" + "group by name, Type, HccCode\r\n"
			+ "order by total desc\r\n" + "limit 7";

	public static final String PATIENT_PROVIDER_REPORT_STANDALONE = "select distinct a.Npi , gu2.FirstName as Updated_User_FN, gu2.LastName as Updated_User_LN , gr.RoleName as Updated_User_RoleName, ga.`Type` ,\r\n"
			+ "ge.Name , Date(a.UpdateDttm) , Date(a.CreateDttm), gu3.FirstName as Create_User_FN, gu3.LastName as Create_User_LN ,\r\n"
			+ "gp.FirstName as Patient_FN, gp.LastName as Patient_LN, gm.SystemIdValue as Member_Id\r\n"
			+ "from dtcr01.attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga ,\r\n"
			+ " dtcr01.gbl_entity ge , dtcr01.gbl_user gu3 , dtcr01.gbl_person gp , dtcr01.gbl_memberidentity gm, \r\n"
			+ " dtcr01.gbl_userhierarchy uh, dtcr01.gbl_userHierarchyRoleLink rl, dtcr01.gbl_role gr \r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate\r\n"
			+ "and gu.UserId = gu2.UserId and a.EntityId = ge.EntityId\r\n" + "and a.UpdateUser = gu2.UserId\r\n"
			+ "and a.CreateUser = gu3.UserId\r\n" + "and gu2.UserId = uh.UserId\r\n"
			+ "and uh.UserHierarchyId = rl.UserHierarchyId\r\n" + "and rl.RoleId = gr.RoleId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and gp.PersonId = a.PersonId\r\n"
			+ "and gp.PersonId = gm.PersonId\r\n"
			+ "and gm.SystemId = '5f48ebac-24f0-4bfe-a630-81aa67b37c92' and ge.Name not in ('HCPCA', 'HCPFL')"
			+ "and ga.Type = 'DatacoreStandalone' \r\n" + "order by Date(a.UpdateDttm), ge.Name , ga.`Type`";

	public static final String PATIENT_PROVIDER_REPORT_CA_STANDALONE = "select distinct a.Npi , gu2.FirstName as Updated_User_FN, gu2.LastName as Updated_User_LN , gr.RoleName as Updated_User_RoleName, ga.`Type` ,\r\n"
			+ "ge.Name , Date(a.UpdateDttm) , Date(a.CreateDttm), gu3.FirstName as Create_User_FN, gu3.LastName as Create_User_LN ,\r\n"
			+ "gp.FirstName as Patient_FN, gp.LastName as Patient_LN, gm.SystemIdValue as Member_Id\r\n"
			+ "from dtcr01.attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga ,\r\n"
			+ " dtcr01.gbl_entity ge , dtcr01.gbl_user gu3 , dtcr01.gbl_person gp , dtcr01.gbl_memberidentity gm, \r\n"
			+ " dtcr01.gbl_userhierarchy uh, dtcr01.gbl_userHierarchyRoleLink rl, dtcr01.gbl_role gr \r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate\r\n"
			+ "and gu.UserId = gu2.UserId and a.EntityId = ge.EntityId\r\n" + "and a.UpdateUser = gu2.UserId\r\n"
			+ "and a.CreateUser = gu3.UserId\r\n" + "and gu2.UserId = uh.UserId\r\n"
			+ "and uh.UserHierarchyId = rl.UserHierarchyId\r\n" + "and rl.RoleId = gr.RoleId\r\n"
			+ "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n" + "and gp.PersonId = a.PersonId\r\n"
			+ "and gp.PersonId = gm.PersonId\r\n"
			+ "and gm.SystemId = 'f3b741ce-37b1-11ea-b389-0242ac110002' and ge.Name = 'HCPCA'"
			+ "and ga.Type = 'DatacoreStandalone' \r\n" + "order by Date(a.UpdateDttm), ge.Name , ga.`Type`";

	public static final String PATIENT_PROVIDER_REPORT_INTEGRATED = "select distinct a.Npi , gu2.FirstName as Updated_User_FN, gu2.LastName as Updated_User_LN , ga.`Type` ,\r\n"
			+ "ge.Name , Date(a.UpdateDttm) , Date(a.CreateDttm), gu3.FirstName as Create_User_FN, gu3.LastName as Create_User_LN ,\r\n"
			+ "gp.FirstName as Patient_FN, gp.LastName as Patient_LN , gm.SystemIdValue as Member_Id\r\n"
			+ "from dtcr01.attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 , dtcr01.gbl_applicationtype ga , \r\n"
			+ "dtcr01.gbl_entity ge , dtcr01.gbl_user gu3 , dtcr01.gbl_person gp , dtcr01.gbl_memberidentity gm\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate\r\n"
			+ "and gu.UserId = gu2.UserId and a.EntityId = ge.EntityId\r\n" + "and a.UpdateUser = gu2.UserId\r\n"
			+ "and a.CreateUser = gu3.UserId\r\n" + "and a.ApplicationTypeId = ga.ApplicationTypeId\r\n"
			+ "and gp.PersonId = a.PersonId\r\n" + "and gp.PersonId = gm.PersonId\r\n"
			+ "and gm.SystemId = 'f3b741ce-37b1-11ea-b389-0242ac110002'"
			+ "and ga.Type = 'DatacoreIntegrated' \r\n  and ge.Name in ('HCPCA', 'HCPFL')"
			+ "order by Date(a.UpdateDttm), ge.Name , ga.`Type` ";

	public static final String PATIENT_PROVIDER_REPORT_NW = "select distinct a.UserId , gu2.FirstName as Updated_User_FN, gu2.LastName as Updated_User_LN , ga.`Type` ,\r\n"
			+ "ge.Name , Date(a.UpdateDttm) , Date(a.CreateDttm), gu3.FirstName as Create_User_FN, gu3.LastName as Create_User_LN ,\r\n"
			+ "gp.FirstName as Patient_FN, gp.LastName as Patient_LN, gm.SystemIdValue as MRN\r\n"
			+ "from dtcr01.dc_trans_hcc_attestation a, dtcr01.gbl_usersystemidentity gu , dtcr01.gbl_user gu2 ,\r\n"
			+ " dtcr01.gbl_applicationtype ga , dtcr01.gbl_entity ge , dtcr01.gbl_user gu3 , dtcr01.gbl_person gp , dtcr01.gbl_memberidentity gm\r\n"
			+ "where Date(a.UpdateDttm) between :startDate and :endDate\r\n" + "and gu.UserId = gu2.UserId\r\n"
			+ "and a.EntityId = '6be074ff-c02b-4b84-a3ae-ef2c6ccbc950'\r\n" + "and a.EntityId = ge.EntityId\r\n"
			+ "and a.UpdateUser = gu2.UserId\r\n" + "and a.CreateUser = gu3.UserId\r\n"
			+ "and ga.ApplicationTypeId = 'b91fa1ef-9074-11ea-ad18-005056b78696'\r\n"
			+ "and gp.PersonId = a.MemberId\r\n" + "and gp.PersonId = gm.PersonId\r\n"
			+ "and gm.SystemId = 'f3b741ce-37b1-11ea-b389-0242ac110002'\r\n" + "and ge.Name = 'NEWWEST'\r\n"
			+ "order by Date(a.UpdateDttm), ge.Name , ga.`Type`";

	public static final String METRICS_REPORT = "MetricsReport";

	public static final String CLINICAL_REPORT = "ClinicalChartReport";
}
