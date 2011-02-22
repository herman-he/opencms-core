/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/ade/sitemap/shared/Attic/CmsPropertyModification.java,v $
 * Date   : $Date: 2011/02/22 09:22:40 $
 * Version: $Revision: 1.2 $
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

package org.opencms.ade.sitemap.shared;

import org.opencms.util.CmsUUID;

import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * A class which represents a property modification.<p>
 * 
 * @author Georg Westenberger 
 * 
 * @version $Revision: 1.2 $ 
 * 
 * @since 8.0.0
 */
public class CmsPropertyModification implements IsSerializable {

    /** The resource id for which the property changed. */
    private CmsUUID m_id;

    /** A flag which indicates whether the structure value changed. */
    private boolean m_isStructureValue;

    /** The name of the property. */
    private String m_name;

    /** The new value. */
    private String m_value;

    /**
    * Copy constructor.<p>
    * 
    * @param propMod the modification bean from which to copy the data 
    */
    public CmsPropertyModification(CmsPropertyModification propMod) {

        m_id = propMod.m_id;
        m_name = propMod.m_name;
        m_value = propMod.m_value;
        m_isStructureValue = propMod.m_isStructureValue;
    }

    /**
     * Creates a new property modification bean.<p>
     * @param path a path of the form id/propertyname/mode, where mode is either S for structure or R for resource
     *  
     * @param value the new property value 
     */
    public CmsPropertyModification(String path, String value) {

        String[] pathComponents = path.split("/");
        String idStr = pathComponents[0];
        String propName = pathComponents[1];
        String mode = pathComponents[2];
        CmsUUID id = new CmsUUID(idStr);
        m_id = id;
        m_name = propName;
        m_value = value;
        m_isStructureValue = mode.equals(CmsClientProperty.PATH_STRUCTURE_VALUE);
    }

    /**
      * Empty constructor for serialization.<p>
      */
    protected CmsPropertyModification() {

        // empty constructor for serialization 
    }

    /**
     * Applies the change to the model.<p>
     * 
     * @param controller the sitemap controller to use 
     */
    public void execute(I_CmsSitemapController controller) {

        Map<String, CmsClientProperty> props = controller.getPropertiesForId(getId());
        if (props != null) {
            updatePropertyInMap(props);
        }
    }

    /** 
     * Returns the id of the resource for which to change properties.<p>
     * 
     * @return the id of ther resource for which to change properties 
     */
    public CmsUUID getId() {

        return m_id;
    }

    /**
     * Returns the property name.<p>
     * 
     * @return the property name 
     */
    public String getName() {

        return m_name;
    }

    /**
     * Returns the new value.<p>
     * 
     * @return the new value 
     */
    public String getValue() {

        return m_value;
    }

    /**
     * Flag which indicates a structure value change.<p>
     * 
     * @return true if the structure value was changed 
     */
    public boolean isStructureValue() {

        return m_isStructureValue;
    }

    /**
     * Helper method for applying the change to a property map.<p>
     * 
     * @param props a map of properties 
     */
    private void updatePropertyInMap(Map<String, CmsClientProperty> props) {

        CmsClientProperty prop = props.get(getName());
        if (prop == null) {
            prop = new CmsClientProperty(getName(), "", "");
            props.put(getName(), prop);
        }
        if (isStructureValue()) {
            prop.setStructureValue(getValue());
        } else {
            prop.setResourceValue(getValue());
        }
    }

}