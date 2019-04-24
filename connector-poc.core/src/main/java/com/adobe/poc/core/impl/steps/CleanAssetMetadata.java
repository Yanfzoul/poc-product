package com.adobe.poc.core.impl.steps;

import java.util.Collections;

import javax.jcr.Session;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.resource.api.JcrResourceConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.commons.util.DamUtil;
import com.day.cq.dam.scene7.api.constants.Scene7Constants;

@Component(service = WorkflowProcess.class, immediate = true, property = {"process.label=Clean Asset Metadata" })
public class CleanAssetMetadata implements WorkflowProcess {

	private static final Logger LOGGER = LoggerFactory.getLogger(CleanAssetMetadata.class);

	private static final String JCR_CONTENT_METADATA_PATH = "/jcr:content/metadata";

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	@Override
	public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
		try {
			ResourceResolver resourceResolver = getResourceResolver(workflowSession);
			Asset asset = getAssetFromWorkItem(resourceResolver, workItem);
			removeDamScene7NameMetadata(resourceResolver, asset);
			resourceResolver.commit();
		} catch (Exception exception) {
			LOGGER.error("Error moving Pending Approval Asset", exception);
		}
	}

	private void removeDamScene7NameMetadata(ResourceResolver resourceResolver, Asset asset) {
		Resource metadataResource = resourceResolver.getResource(asset.getPath() + JCR_CONTENT_METADATA_PATH);
		ModifiableValueMap modifiableValueMap = metadataResource.adaptTo(ModifiableValueMap.class);
		
		if (modifiableValueMap.containsKey(Scene7Constants.PN_S7_FILE)) {
			modifiableValueMap.remove(Scene7Constants.PN_S7_FILE);
		}
	}

	private ResourceResolver getResourceResolver(WorkflowSession workflowSession) throws LoginException {
		Session session = workflowSession.adaptTo(Session.class);
		return resourceResolverFactory.getResourceResolver(Collections.singletonMap(JcrResourceConstants.AUTHENTICATION_INFO_SESSION, session));
	}

	private Asset getAssetFromWorkItem(ResourceResolver resourceResolver, WorkItem workItem) {
		Resource originalRenditionResource = resourceResolver.getResource(workItem.getContentPath());
		return DamUtil.resolveToAsset(originalRenditionResource);
	}

}
