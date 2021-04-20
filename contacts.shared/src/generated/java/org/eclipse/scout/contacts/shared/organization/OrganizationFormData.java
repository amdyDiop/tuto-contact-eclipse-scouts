package org.eclipse.scout.contacts.shared.organization;

import javax.annotation.Generated;

import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.properties.AbstractPropertyData;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications
 * recommended.
 */
@Generated(value = "org.eclipse.scout.contacts.client.organization.OrganizationForm", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class OrganizationFormData extends AbstractFormData {
	private static final long serialVersionUID = 1L;

	/**
	 * access method for property OrganizationId.
	 */
	public String getOrganizationId() {
		return getOrganizationIdProperty().getValue();
	}

	/**
	 * access method for property OrganizationId.
	 */
	public void setOrganizationId(String organizationId) {
		getOrganizationIdProperty().setValue(organizationId);
	}

	public OrganizationIdProperty getOrganizationIdProperty() {
		return getPropertyByClass(OrganizationIdProperty.class);
	}

	public static class OrganizationIdProperty extends AbstractPropertyData<String> {
		private static final long serialVersionUID = 1L;
	}
}
