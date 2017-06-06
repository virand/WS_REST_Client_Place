import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by virand on 6/6/2017.
 */


    @XmlRootElement
    public class Place {
        private int id;
        private String name;
        private String description;
        private String city;
        private String address;

        public Place() {

        }

        public Place(int aId, String aName, String aDescription, String aCity, String aAddress)
        {
            id=aId;
            name=aName;
            description=aDescription;
            city=aCity;
            address=aAddress;
        }

        public String getName(){
            return name;
        }

        public String getDescription(){
            return description;
        }

        public String getCity(){
            return city;
        }

        public String getAddress()
        {
            return address;
        }

        public void setName(String aName){
            name=aName;
        }

        public void setDescription(String aDescription)
        {
            description=aDescription;
        }

        public void setCity(String aCity)
        {
            city=aCity;
        }

        public void setAddress(String aAddress)
        {
            address=aAddress;
        }

        @Override
        public String toString(){
            return "Place{"+"name = " + name + " description = " + description + " city = " + city + " address = " + address;
        }
    }