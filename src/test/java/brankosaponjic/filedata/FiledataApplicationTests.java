package brankosaponjic.filedata;

import brankosaponjic.filedata.entity.Image;
import brankosaponjic.filedata.repository.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
class FiledataApplicationTests {

    @Autowired
    ImageRepository imageRepository;

    @Test
    void testImageSave() throws IOException {
        Image image = new Image();
        image.setId(2L);
        image.setName("SQL.JPG");

        String path = "C:\\Users\\Branko\\Desktop\\images for developing\\data jpg\\SQL.JPG";
        File file = new File(path);
        byte[] fileContent = new byte[(int) file.length()];
        FileInputStream inputStream = new FileInputStream(file);
        inputStream.read(fileContent);

        image.setData(fileContent);
        imageRepository.save(image);
        inputStream.close();
    }
}
