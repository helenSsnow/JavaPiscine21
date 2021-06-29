
public class UserIdsGenerator {
    private int id = 0;
    private static UserIdsGenerator objectId;

    private UserIdsGenerator(){}
    public static UserIdsGenerator getInstance(){
        if(objectId == null)
            objectId = new UserIdsGenerator();
        return objectId;
    }

    public int generateId() {
        id++;
        return id;
    }
}