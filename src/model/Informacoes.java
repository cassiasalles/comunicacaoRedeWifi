package model;

public class Informacoes {
	private String contactName;
    private String userName;
    private String contactIp;
    private String userIp;
    private int port;
    private String message;
    private String pathImage;

    public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactIp() {
		return contactIp;
	}

	public void setContactIp(String contactIp) {
		this.contactIp = contactIp;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
    
}
