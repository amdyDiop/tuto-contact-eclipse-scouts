package org.eclipse.scout.contacts.server.person;

import java.util.UUID;

import org.eclipse.scout.contacts.server.sql.SQLs;
import org.eclipse.scout.contacts.shared.person.IPersonService;
import org.eclipse.scout.contacts.shared.person.PersonFormData;
import org.eclipse.scout.contacts.shared.person.PersonTablePageData;
import org.eclipse.scout.contacts.shared.person.UpdatePersonPermission;
import org.eclipse.scout.rt.platform.exception.VetoException;
import org.eclipse.scout.rt.platform.holders.NVPair;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.eclipse.scout.rt.security.ACCESS;
import org.eclipse.scout.rt.server.jdbc.SQL;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class PersonService implements IPersonService {
	@Override
	public PersonTablePageData getPersonTableData(SearchFilter filter) {
		PersonTablePageData pageData = new PersonTablePageData();
		String sql = SQLs.PERSON_PAGE_SELECT + SQLs.PERSON_PAGE_DATA_SELECT_INTO;
		SQL.selectInto(sql, new NVPair("page", pageData));
		return pageData;
	}

	@Override
	public PersonFormData prepareCreate(PersonFormData formData) {
		// if (!ACCESS.check(new CreatePersonPermission())) {
		// throw new VetoException(TEXTS.get("AuthorizationFailed"));
		// }
		// TODO [amdy] add business logic here.
		return formData;
	}

	@Override
	public PersonFormData create(PersonFormData formData) {
		// if (!ACCESS.check(new CreatePersonPermission())) {
		// throw new VetoException(TEXTS.get("AuthorizationFailed"));
		// }
		// TODO [amdy] add business logic here.
		if (StringUtility.isNullOrEmpty(formData.getPersonId())) {
			formData.setPersonId(UUID.randomUUID().toString());
		}
		SQL.insert(SQLs.PERSON_INSERT, formData);
		return store(formData);
	}

	@Override
	public PersonFormData load(PersonFormData formData) {
		// if (!ACCESS.check(new ReadPersonPermission())) {
		// throw new VetoException(TEXTS.get("AuthorizationFailed"));
		// }
		SQL.selectInto(SQLs.PERSON_SELECT, formData);
		return formData;
	}

	@Override
	public PersonFormData store(PersonFormData formData) {
//		if (!ACCESS.check(new UpdatePersonPermission())) {
//			throw new VetoException(TEXTS.get("AuthorizationFailed"));
//		}
		SQL.update(SQLs.PERSON_UPDATE, formData);
		return formData;
	}
}
