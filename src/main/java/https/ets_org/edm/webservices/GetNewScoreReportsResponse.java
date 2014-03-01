
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
 *         &lt;element name="GetNewScoreReportsResult" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
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
    "getNewScoreReportsResult"
})
@XmlRootElement(name = "GetNewScoreReportsResponse")
public class GetNewScoreReportsResponse {

    @XmlElement(name = "GetNewScoreReportsResult")
    protected byte[] getNewScoreReportsResult;

    /**
     * Gets the value of the getNewScoreReportsResult property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGetNewScoreReportsResult() {
        return getNewScoreReportsResult;
    }

    /**
     * Sets the value of the getNewScoreReportsResult property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGetNewScoreReportsResult(byte[] value) {
        this.getNewScoreReportsResult = value;
    }

}
