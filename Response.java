import com.google.common.collect.ImmutableMap;

public class Response {
    static ImmutableMap<String, String> RESPONSES;
    static {
        RESPONSES =
            new ImmutableMap.Builder<String, String>()
            .put("weather", "There is an 80% chance of rain this afternoon."
             + "  The high will be 8 and the low 2.")
            .put("window", "Sensors indicate that all windows are closed.")
            .put("heat down", "Your thermostat is currently set to 20.")
            .put("thermostat", "Setting thermostat to 15.")
            .put("oven off", "Do not worry. Your oven is off.")
            .put("walked", "You walked 1.3 kilometers so far.")
            .put("this week", "You are doing great!"
                /**/          + "  Walk another half kilometer,"
                /**/          + " and you will meet your goal for the week.")
            .put("help", "Sending help to your location now.")
            .put("fnord", "Do not see the fnord!")
            .build();
    }
    static public void main(String argv[]) {
        System.out.println(RESPONSES.get(argv[0]));
    }
}
