public package org.springframework.samples.petclinic.model;
@Entity
public class TrainingCenter {

    private Long id;
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 40)
    private String centerName;

    @NotNull
    @Size(min = 12, max = 12)
    private String centerCode;

    @Embedded
    private Address address;

    private int studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    private Long createdOn;

    @Email
    private String contactEmail;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String contactPhone;

}