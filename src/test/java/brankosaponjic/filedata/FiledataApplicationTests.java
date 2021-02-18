package brankosaponjic.filedata;

import brankosaponjic.filedata.entity.Image;
import brankosaponjic.filedata.repository.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@SpringBootTest
class FiledataApplicationTests {

    @Autowired
    ImageRepository imageRepository;

    @Test
    void testReadImage() {
        Optional<Image> image = imageRepository.findById(2L);

        String path = "C:\\Users\\Branko\\Desktop\\images for developing\\data jpg\\downloaded file\\";
        File file = new File(path + image.get().getName());
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            fos.write(image.get().getData());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
