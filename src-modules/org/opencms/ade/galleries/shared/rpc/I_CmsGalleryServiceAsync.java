/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/ade/galleries/shared/rpc/Attic/I_CmsGalleryServiceAsync.java,v $
 * Date   : $Date: 2011/01/19 14:18:47 $
 * Version: $Revision: 1.9 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2002 - 2009 Alkacon Software (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.ade.galleries.shared.rpc;

import org.opencms.ade.galleries.shared.CmsGalleryDataBean;
import org.opencms.ade.galleries.shared.CmsGalleryFolderBean;
import org.opencms.ade.galleries.shared.CmsGallerySearchBean;
import org.opencms.ade.galleries.shared.CmsVfsEntryBean;
import org.opencms.gwt.shared.CmsCategoryTreeEntry;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Handles all RPC services related to the gallery dialog.<p>
 * 
 * @author Polina Smagina
 * 
 * @version $Revision: 1.9 $ 
 * 
 * @since 8.0.0
 * 
 * @see org.opencms.ade.galleries.CmsGalleryService
 * @see org.opencms.ade.galleries.shared.rpc.I_CmsGalleryService
 * @see org.opencms.ade.galleries.shared.rpc.I_CmsGalleryServiceAsync
 */
public interface I_CmsGalleryServiceAsync {

    /**
     * Returns all available categories for given galleries.<p>
     * 
     * @param galleries the galleries
     * @param callback the callback
     */
    void getCategoryTreeGalleries(List<String> galleries, AsyncCallback<CmsCategoryTreeEntry> callback);

    /**
     * Returns all available categories for given resource types, by looking up associated galleries first.<p>
     * 
     * Only use this if no galleries list is available.<p>
     * 
     * @param types the resource types
     * @param callback the callback
     */
    void getCategoryTreeTypes(List<String> types, AsyncCallback<CmsCategoryTreeEntry> callback);

    /**
     * Returns the available galleries depending on the given resource types.<p>
     * 
     * @param resourceTypes the resource types
     * @param callback the callback
     */
    void getGalleries(List<String> resourceTypes, AsyncCallback<List<CmsGalleryFolderBean>> callback);

    /**
     * Returns the initial data for the given gallery mode.<p>
     * 
     * @param callback the callback
     */
    void getInitialSettings(AsyncCallback<CmsGalleryDataBean> callback);

    /**
     * Performs an initial search based on the given data bean and the available parameters of the request.<p>
     * 
     * @param data the data bean
     * @param callback the callback
     */
    void getSearch(CmsGalleryDataBean data, AsyncCallback<CmsGallerySearchBean> callback);

    /**
     * Returns the gallery search object containing search results and the currant search parameter.<p>  
     * 
     * @param searchObj the current search object
     * @param callback the callback
     */
    void getSearch(CmsGallerySearchBean searchObj, AsyncCallback<CmsGallerySearchBean> callback);

    /**
     * Gets the sub-folders of a folder.<p>
     * 
     * @param path the path of a folder
     * @param callback the asynchronous callback 
     */
    void getSubFolders(String path, AsyncCallback<List<CmsVfsEntryBean>> callback);
}
