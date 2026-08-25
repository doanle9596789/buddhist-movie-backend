package org.example;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    private final List<Movie> classicList = new ArrayList<>();
    private final List<Movie> animationList = new ArrayList<>();
    private final List<AudioItem> audioList = new ArrayList<>();

    public MovieController() {
        classicList.add(new Movie(
                "phim-01", "Cuộc Đời Đức Phật Thích Ca", "Sử Thi", "Tập 1 - 55", "Ấn Độ", "9.8",
                "https://images.unsplash.com/photo-1544816155-12df9643f363?auto=format&fit=crop&w=500&q=80",
                "https://www.youtube.com/embed/n4q06RkS6E8",
                "Hành trình từ Thái tử Tất-đạt-đa từ bỏ ngai vàng để tìm cầu chân lý giải thoát."
        ));

        animationList.add(new Movie(
                "hh-01", "Chú Tiểu Thông Minh Nhất Hưu", "Hoạt Hình", "Tập 1", "Tuệ Giác", "9.5",
                "https://images.unsplash.com/photo-1579783900882-c0d3dad7b119?auto=format&fit=crop&w=500&q=80",
                "https://www.youtube.com/embed/fJ9rUzIMcZQ",
                "Câu chuyện về chú tiểu Ikkyu thông minh, ngộ nghĩnh và giàu lòng từ bi."
        ));

        audioList.add(new AudioItem(
                "audio-01", "Chú Đại Bi (84 Câu - Tiếng Phạn)", "Tịnh Tâm - Trừ Chướng Ngại",
                "https://images.unsplash.com/photo-1506126613408-eca07ce68773?auto=format&fit=crop&w=300&q=80",
                "https://www.youtube.com/embed/rVqB8fQoKTo"
        ));
    }

    @GetMapping("/classics")
    public List<Movie> getClassicMovies() {
        return classicList;
    }

    @GetMapping("/animations")
    public List<Movie> getAnimationMovies() {
        return animationList;
    }

    @GetMapping("/audios")
    public List<AudioItem> getAudios() {
        return audioList;
    }

    @PostMapping("/upload")
    public Movie uploadMovie(@RequestBody Movie movie, @RequestParam(defaultValue = "classic") String category) {
        if (movie.getId() == null || movie.getId().isEmpty()) {
            movie.setId("phim-" + UUID.randomUUID().toString().substring(0, 8));
        }
        if ("animation".equalsIgnoreCase(category)) {
            animationList.add(0, movie);
        } else {
            classicList.add(0, movie);
        }
        return movie;
    }
}