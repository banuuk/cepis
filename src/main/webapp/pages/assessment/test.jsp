<ui:composition xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:a4j="http://richfaces.org/a4j"
      xmlns:rich="http://richfaces.org/rich">
      <f:view>     
    <style type="text/css">
        .col {
            width:50%;
            padding:10px;
            padding: 0px 30px 0px 0px;
            vertical-align: top;
        }
    </style>            
            
    <br/> 
            
    <h:panelGrid columns="2" width="100%" columnClasses="col">

          

            <h:panelGroup>
                This code works properly. The <code>h:message</code> is marked for update during
                each Ajaxrequest/response. The place for bottom label is reserved with
                <code>outputPanel</code> while  the component is not rendered.
            </h:panelGroup>

            


            
            <a4j:outputPanel layout="block">

                <a4j:outputPanel ajaxRendered="true">
                    <h:message for="text2" style="color:red" />
                </a4j:outputPanel>
            
                <a4j:outputPanel layout="block">
                    <h:form>
                        <h:outputText style="font-weight: bold;" value="Enter Text: "/>
                        <h:inputText id="text2" label="text2" value="Hello}">
                            <f:validateLength maximum="10"/>
                            <a4j:support event="onkeyup" reRender="out2" />
                        </h:inputText>
                    </h:form>
                </a4j:outputPanel>
                
                <a4j:outputPanel id="out2">
                    <h:outputText  value="Approved Text: Hello" />
                </a4j:outputPanel>
            </a4j:outputPanel>
    </h:panelGrid>
	
    <br/>
</f:view> 
</ui:composition>