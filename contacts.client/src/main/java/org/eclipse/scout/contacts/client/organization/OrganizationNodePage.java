package org.eclipse.scout.contacts.client.organization;

import java.util.List;

import org.eclipse.scout.contacts.client.person.PersonTablePage;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.text.TEXTS;

public class OrganizationNodePage extends AbstractPageWithNodes {

	private String organizationId;

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	protected void execCreateChildPages(List<IPage<?>> pageList) {
		PersonTablePage personTablePage = new PersonTablePage();
		personTablePage.setOrganizationId(getOrganizationId());
		pageList.add(personTablePage);
	}

	@Override
	protected String getConfiguredTitle() {
		// TODO [amdy] verify translation
		return TEXTS.get("OrganizationNodePage");
	}
}
