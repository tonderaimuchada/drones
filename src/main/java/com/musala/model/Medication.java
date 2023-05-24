import javax.validation.constraints.Pattern;

public class Medication {
    @Pattern(regexp="^[a-zA-Z0-9_-]+$")
    private String name;
    private float weight;
    @Pattern(regexp="^[A-Z0-9_]+$")
    private String code;
    private byte[] image;
}