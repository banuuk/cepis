/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package edu.uky.cepis.calendar;

import java.io.Serializable;
import org.apache.myfaces.custom.schedule.model.ScheduleModel;

/**
 * Handler class that contains the settings of the customizable schedule example.
 * @author  Jurgen Lust (latest modification by $Author$)
 * @version  $Revision$
 */
public class ScheduleSettings implements Serializable
{
    private static final long serialVersionUID = -8547428935814382762L;

    /**
	 * @uml.property  name="compactMonthRowHeight"
	 */
    private int compactMonthRowHeight;

    /**
	 * @uml.property  name="compactWeekRowHeight"
	 */
    private int compactWeekRowHeight;

    /**
	 * @uml.property  name="detailedRowHeight"
	 */
    private int detailedRowHeight;

    /**
	 * @uml.property  name="headerDateFormat"
	 */
    private String headerDateFormat;

    /**
	 * @uml.property  name="model"
	 */
    private ScheduleModel model;

    /**
	 * @uml.property  name="readonly"
	 */
    private boolean readonly;

    /**
	 * @uml.property  name="theme"
	 */
    private String theme;

    /**
	 * @uml.property  name="tooltip"
	 */
    private boolean tooltip;

    /**
	 * @uml.property  name="visibleEndHour"
	 */
    private int visibleEndHour;

    /**
	 * @uml.property  name="visibleStartHour"
	 */
    private int visibleStartHour;

    /**
	 * @uml.property  name="workingEndHour"
	 */
    private int workingEndHour;

    /**
	 * @uml.property  name="workingStartHour"
	 */
    private int workingStartHour;

    /**
	 * @uml.property  name="renderZeroLength"
	 */
    private boolean renderZeroLength;
    
    /**
	 * @uml.property  name="expandToFitEntries"
	 */
    private boolean expandToFitEntries;

    /**
	 * @return
	 * @uml.property  name="compactMonthRowHeight"
	 */
    public int getCompactMonthRowHeight()
    {
        return compactMonthRowHeight;
    }

    /**
	 * @return
	 * @uml.property  name="compactWeekRowHeight"
	 */
    public int getCompactWeekRowHeight()
    {
        return compactWeekRowHeight;
    }

    /**
	 * @return
	 * @uml.property  name="detailedRowHeight"
	 */
    public int getDetailedRowHeight()
    {
        return detailedRowHeight;
    }

    /**
	 * @return
	 * @uml.property  name="headerDateFormat"
	 */
    public String getHeaderDateFormat()
    {
        return headerDateFormat;
    }

    /**
	 * @return
	 * @uml.property  name="model"
	 */
    public ScheduleModel getModel()
    {
        return model;
    }

    /**
	 * @return
	 * @uml.property  name="theme"
	 */
    public String getTheme()
    {
        return theme;
    }

    /**
	 * @return
	 * @uml.property  name="visibleEndHour"
	 */
    public int getVisibleEndHour()
    {
        return visibleEndHour;
    }

    /**
	 * @return
	 * @uml.property  name="visibleStartHour"
	 */
    public int getVisibleStartHour()
    {
        return visibleStartHour;
    }

    /**
	 * @return
	 * @uml.property  name="workingEndHour"
	 */
    public int getWorkingEndHour()
    {
        return workingEndHour;
    }

    /**
	 * @return
	 * @uml.property  name="workingStartHour"
	 */
    public int getWorkingStartHour()
    {
        return workingStartHour;
    }

    /**
	 * @return
	 * @uml.property  name="readonly"
	 */
    public boolean isReadonly()
    {
        return readonly;
    }

    /**
	 * @return
	 * @uml.property  name="tooltip"
	 */
    public boolean isTooltip()
    {
        return tooltip;
    }

    public String save()
    {
        model.refresh();
        return "success";
    }

    /**
	 * @param compactMonthRowHeight
	 * @uml.property  name="compactMonthRowHeight"
	 */
    public void setCompactMonthRowHeight(int compactMonthRowHeight)
    {
        this.compactMonthRowHeight = compactMonthRowHeight;
    }

    /**
	 * @param compactWeekRowHeight
	 * @uml.property  name="compactWeekRowHeight"
	 */
    public void setCompactWeekRowHeight(int compactWeekRowHeight)
    {
        this.compactWeekRowHeight = compactWeekRowHeight;
    }

    /**
	 * @param detailedRowHeight
	 * @uml.property  name="detailedRowHeight"
	 */
    public void setDetailedRowHeight(int detailedRowHeight)
    {
        this.detailedRowHeight = detailedRowHeight;
    }

    /**
	 * @param headerDateFormat
	 * @uml.property  name="headerDateFormat"
	 */
    public void setHeaderDateFormat(String headerDateFormat)
    {
        this.headerDateFormat = headerDateFormat;
    }

    /**
	 * @param model
	 * @uml.property  name="model"
	 */
    public void setModel(ScheduleModel model)
    {
        this.model = model;
    }

    /**
	 * @param readonly
	 * @uml.property  name="readonly"
	 */
    public void setReadonly(boolean readonly)
    {
        this.readonly = readonly;
    }

    /**
	 * @param theme
	 * @uml.property  name="theme"
	 */
    public void setTheme(String theme)
    {
        this.theme = theme;
    }

    /**
	 * @param tooltip
	 * @uml.property  name="tooltip"
	 */
    public void setTooltip(boolean tooltip)
    {
        this.tooltip = tooltip;
    }

    /**
	 * @param visibleEndHour
	 * @uml.property  name="visibleEndHour"
	 */
    public void setVisibleEndHour(int visibleEndHour)
    {
        this.visibleEndHour = visibleEndHour;
    }

    /**
	 * @param visibleStartHour
	 * @uml.property  name="visibleStartHour"
	 */
    public void setVisibleStartHour(int visibleStartHour)
    {
        this.visibleStartHour = visibleStartHour;
    }

    /**
	 * @param workingEndHour
	 * @uml.property  name="workingEndHour"
	 */
    public void setWorkingEndHour(int workingEndHour)
    {
        this.workingEndHour = workingEndHour;
    }

    /**
	 * @param workingStartHour
	 * @uml.property  name="workingStartHour"
	 */
    public void setWorkingStartHour(int workingStartHour)
    {
        this.workingStartHour = workingStartHour;
    }

    /**
	 * @return  Returns the renderZeroLength.
	 * @uml.property  name="renderZeroLength"
	 */
    public boolean isRenderZeroLength()
    {
        return renderZeroLength;
    }

    /**
	 * @param renderZeroLength  The renderZeroLength to set.
	 * @uml.property  name="renderZeroLength"
	 */
    public void setRenderZeroLength(boolean renderZeroLength)
    {
        this.renderZeroLength = renderZeroLength;
    }

    /**
	 * @return  Returns the expandToFitEntries.
	 * @uml.property  name="expandToFitEntries"
	 */
    public boolean isExpandToFitEntries()
    {
        return expandToFitEntries;
    }

    /**
	 * @param expandToFitEntries  The expandToFitEntries to set.
	 * @uml.property  name="expandToFitEntries"
	 */
    public void setExpandToFitEntries(boolean expandToFitEntries)
    {
        this.expandToFitEntries = expandToFitEntries;
    }
    
    public String getMode() {
        return String.valueOf(getModel().getMode());
    }
    
    public void setMode(String mode) {
        getModel().setMode(Integer.valueOf(mode).intValue());
    }
}
