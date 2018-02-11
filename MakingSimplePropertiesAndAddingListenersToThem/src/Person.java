import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person
{
    //We don't use a normal String but instead we use StringProperty (which is an abstract class so we are not
    //creating its object but SimpleStringProperty's object) so that we can add listener to our firstName
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    //Normal Getter for a String
    public String getFirstName() {
        return firstName.get();
    }

    //Returns a StringProperty object. This object will have the address of the firstName object so never
    //directly display this as a whole to the user
    public StringProperty firstNameProperty() {
        return firstName;
    }

    //Normal Setter for a String
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
