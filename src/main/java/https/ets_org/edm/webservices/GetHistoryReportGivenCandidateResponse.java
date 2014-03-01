
package https.ets_org.edm.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetHistoryReportGivenCandidateResult" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getHistoryReportGivenCandidateResult"
})
@XmlRootElement(name = "GetHistoryReportGivenCandidateResponse")
public class GetHistoryReportGivenCandidateResponse {

    @XmlElement(name = "GetHistoryReportGivenCandidateResult")
    protected byte[] getHistoryReportGivenCandidateResult;

    /**
     * Gets the value of the getHistoryReportGivenCandidateResult property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGetHistoryReportGivenCandidateResult() {
        return getHistoryReportGivenCandidateResult;
    }

    /**
     * Sets the value of the getHistoryReportGivenCandidateResult property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGetHistoryReportGivenCandidateResult(byte[] value) {
        this.getHistoryReportGivenCandidateResult = value;
    }

}
