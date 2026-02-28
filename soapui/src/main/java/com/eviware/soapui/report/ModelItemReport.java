

package com.eviware.soapui.report;

import com.eviware.soapui.config.ReportTypeConfig;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.TestPropertyHolder;
import com.eviware.soapui.support.types.StringToObjectMap;

import java.util.Collection;

public interface ModelItemReport {
    public ModelItem getModelItem();

    public void addSubReport(SubReport subReport);

    public void removeSubReport(SubReport subReport);

    public SubReport[] getSubReports();

    public SubReport getSubReportByName(String name);

    public ReportTypeConfig.Enum getLevel();

    public void prepare();

    public void release();

    public boolean hasSubReport(String id);

    public <T2> Collection<T2> getSubReportsByType(Class<T2> clazz);

    public void onGenerate(StringToObjectMap params);

    public TestPropertyHolder getModelItemReportParameters();
}
