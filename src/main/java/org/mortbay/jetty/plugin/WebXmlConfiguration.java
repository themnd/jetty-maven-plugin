package org.mortbay.jetty.plugin;

import java.io.IOException;
import java.net.MalformedURLException;

import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebXmlConfiguration extends org.eclipse.jetty.webapp.WebXmlConfiguration
{
  String customWebXml = null;
  
  public String getCustomWebXml()
  {
    return customWebXml;
  }

  public void setCustomWebXml(String customWebXml)
  {
    this.customWebXml = customWebXml;
  }

  @Override
  protected Resource findWebXml(WebAppContext context) throws IOException, MalformedURLException
  {
    if (customWebXml != null) {
      Resource webXml = Resource.newResource(customWebXml);
      if (webXml.exists()) {
        return webXml;
      }
    }

    return super.findWebXml(context);
  }

}
