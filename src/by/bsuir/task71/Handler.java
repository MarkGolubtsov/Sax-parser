package by.bsuir.task71;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {
    private int countAll=0;
    private String name;
    private boolean isNewUser = false;
    private boolean isEmail = false;
    private boolean isSearchUser = false;
    private int countSkill = 0;
    private boolean isSkill= false;
    private String REG= ".biz";
    private int Xskills;
    private boolean isNeedEmail = false;

    public Handler(int X)
    {
        Xskills=X;
    }

    public int getCountAll() {
        return countAll;
    }

    @Override
    public void startElement(String namespace, String localName, String qName, Attributes attr) {

        if (qName.equals("name")) {
            isNewUser = true;
            isNeedEmail= false;
            countSkill=0;
        } else if (qName.equals("skill")) {
            isSkill = true;
        } else if (qName.equals("email")) {
            isEmail = true;
        }
    }

    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException {
        if(qName.equals("user")  && (countSkill>Xskills) && isNeedEmail){
            System.out.println(name);
            countAll++;
        }
    }
    @Override
    public void characters(char []ch, int start, int end) {
        if(isNewUser) {
            name = new String(ch, start, end);
            isNewUser = false;
        } else if (isSkill) {
            String email1= new String(ch, start, end);
            countSkill++;
            isSkill=false;
        }else if (isEmail) {
            String email = new String(ch, start, end);
            //System.out.println(email);
            isNeedEmail= email.contains(REG);
            isEmail=false;
        }
    }
}

