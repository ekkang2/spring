package co.kr.chhak.document;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "user1")
public class User1Document {

    @Id
    private String _id;

    private String uid;
    private String name;
    private int age;
    private String addr;
}
