package org.eclipse.scout.contacts.server.organization;

import java.util.UUID;

import org.eclipse.scout.contacts.server.sql.SQLs;
import org.eclipse.scout.contacts.shared.organization.IOrganizationService;
import org.eclipse.scout.contacts.shared.organization.OrganizationFormData;
import org.eclipse.scout.contacts.shared.organization.OrganizationTablePageData;
import org.eclipse.scout.rt.platform.holders.NVPair;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.eclipse.scout.rt.server.jdbc.SQL;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class OrganizationService implements IOrganizationService {
	@Override
	public OrganizationFormData create(OrganizationFormData formData) {

		if (StringUtility.isNullOrEmpty(formData.getOrganizationId())) {
			formData.setOrganizationId(UUID.randomUUID().toString());
		}

		SQL.insert(SQLs.ORGANIZATION_INSERT, formData);

		return store(formData);
	}

	@Override
	public OrganizationFormData load(OrganizationFormData formData) {

		SQL.selectInto(SQLs.ORGANIZATION_SELECT, formData);
		return formData;
	}

	@Override
	public OrganizationFormData store(OrganizationFormData formData) {

		SQL.update(SQLs.ORGANIZATION_UPDATE, formData);
		return formData;
	}

	@Override
	public OrganizationTablePageData getOrganizationTableData(SearchFilter filter) {
		OrganizationTablePageData pageData = new OrganizationTablePageData();
		String sql = SQLs.ORGANIZATION_PAGE_SELECT + SQLs.ORGANIZATION_PAGE_DATA_SELECT_INTO;
		SQL.selectInto(sql, new NVPair("page", pageData));
		return pageData;
	}

	@Override
	public OrganizationFormData prepareCreate(OrganizationFormData formData) {
		// TODO Auto-generated method stub
		return null;
	}
}