package org.eclipse.scout.contacts.shared.person;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

@ApplicationScoped
@TunnelToServer
public interface IPersonService extends IService {

	PersonTablePageData getPersonTableData(SearchFilter filter, String organizationId);

	PersonFormData prepareCreate(PersonFormData formData);

	PersonFormData create(PersonFormData formData);

	PersonFormData load(PersonFormData formData);

	PersonFormData store(PersonFormData formData);
}
