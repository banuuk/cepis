/**
 * 
 */
package edu.uky.cepis.util.global;

/**
 * @author  keerthi
 */
public class File {

    private String Name;
    private String mime;
    private long length;
    private byte[] data;
    /**
	 * @return
	 * @uml.property  name="data"
	 */
    public byte[] getData() {
        return data;
    }
    /**
	 * @param data
	 * @uml.property  name="data"
	 */
    public void setData(byte[] data) {
        this.data = data;
    }
    /**
	 * @return
	 * @uml.property  name="name"
	 */
    public String getName() {
        return Name;
    }
    /**
	 * @param name
	 * @uml.property  name="name"
	 */
    public void setName(String name) {
        Name = name;
        int extDot = name.lastIndexOf('.');
        if(extDot > 0){
            String extension = name.substring(extDot +1);
            if("bmp".equals(extension)){
                mime="image/bmp";
            } else if("jpg".equals(extension)){
                mime="image/jpeg";
            } else if("gif".equals(extension)){
                mime="image/gif";
            } else if("png".equals(extension)){
                mime="image/png";
            } else {
                mime = "image/unknown";
            }
        }
    }
    /**
	 * @return
	 * @uml.property  name="length"
	 */
    public long getLength() {
        return length;
    }
    /**
	 * @param length
	 * @uml.property  name="length"
	 */
    public void setLength(long length) {
        this.length = length;
    }
    
    /**
	 * @return
	 * @uml.property  name="mime"
	 */
    public String getMime(){
        return mime;
    }
}