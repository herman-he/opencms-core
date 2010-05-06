/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/ade/galleries/shared/Attic/CmsCategoryInfoBean.java,v $
 * Date   : $Date: 2010/05/06 09:27:20 $
 * Version: $Revision: 1.1 $
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

package org.opencms.ade.galleries.shared;

import org.opencms.gwt.shared.CmsListInfoBean;

import java.util.Map;

/**
 * A specific bean holding all info to be displayed in the categories tab.<p>
 * 
 * The bean can be used for {@link org.opencms.gwt.client.ui.tree.CmsTreeItem}s in a tree or
 * {@link org.opencms.ade.galleries.client.ui.CmsCategoryListItem}s in a list.
 * 
 * @see org.opencms.ade.galleries.client.ui.CmsCategoryListItem
 * @see org.opencms.gwt.client.ui.tree.CmsTreeItem
 * 
 * @author Polina Smagina
 * 
 * @version $Revision: 1.1 $
 * 
 * @since 8.0.0
 */
public class CmsCategoryInfoBean extends CmsListInfoBean
implements I_CmsItemId, Comparable<CmsCategoryInfoBean> {

    /** The category path as id. */
    private String m_categoryPath;

    /** The path to the category icon. */
    private String m_iconResource;

    /**
     * The default constructor.<p>
     */
    public CmsCategoryInfoBean() {

        // empty
    }

    /**
     * The constructor.<p>
     * 
     * @param title the title to set 
     * @param subtitle the subtitle to set
     * @param additionalInfo the additional info
     * @param id category path as id
     * @param iconResource the path to category icon(folder)
     */
    public CmsCategoryInfoBean(
        String title,
        String subtitle,
        Map<String, String> additionalInfo,
        String id,
        String iconResource) {

        super(title, subtitle, additionalInfo);
        m_categoryPath = id;
        m_iconResource = iconResource;
    }

    /**
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    //TODO: what does happen, if title is null?
    public int compareTo(CmsCategoryInfoBean o) {

        return getTitle().compareTo(o.getTitle());
    }

    /**
     * Returns the icon.<p>
     *
     * @return the icon
     */
    public String getIconResource() {

        return m_iconResource;
    }

    /**
     * @see org.opencms.ade.galleries.shared.I_CmsItemId#getId()
     */

    public String getId() {

        return m_categoryPath;
    }

    /**
     * Sets the icon.<p>
     *
     * @param icon the icon to set
     */
    public void setIconResource(String icon) {

        m_iconResource = icon;
    }

    /** 
     * @see org.opencms.ade.galleries.shared.I_CmsItemId#setId(java.lang.String)
     */
    public void setId(String id) {

        m_categoryPath = id;
    }
}