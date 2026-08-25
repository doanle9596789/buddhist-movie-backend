// main.js
const API_BASE_URL = '/api';

const mockData = {
    classics: [
        {
            id: "phim-01",
            title: "Cuộc Đời Đức Phật Thích Ca",
            tag: "Sử Thi",
            episodes: "Tập 1 - 55",
            year: "Ấn Độ",
            rate: "9.9",
            img: "https://images.unsplash.com/photo-1544816155-12df9643f363?auto=format&fit=crop&w=500&q=80",
            videoUrl: "https://www.youtube.com/embed/n4q06RkS6E8",
            desc: "Bộ phim truyền hình tái hiện trọn vẹn cuộc đời Đức Phật Thích Ca."
        }
    ],
    animations: [
        {
            id: "hh-01",
            title: "Chú Tiểu Thông Minh Nhất Hưu",
            tag: "Hoạt Hình",
            episodes: "Tập 1",
            year: "Tuệ Giác",
            rate: "9.5",
            img: "https://images.unsplash.com/photo-1579783900882-c0d3dad7b119?auto=format&fit=crop&w=500&q=80",
            videoUrl: "https://www.youtube.com/embed/fJ9rUzIMcZQ",
            desc: "Câu chuyện về chú tiểu Ikkyu thông minh."
        }
    ],
    audios: [
        {
            id: "audio-01",
            title: "Chú Đại Bi (84 Câu - Tiếng Phạn)",
            author: "Tịnh Tâm - Trừ Chướng Ngại",
            img: "https://images.unsplash.com/photo-1506126613408-eca07ce68773?auto=format&fit=crop&w=300&q=80",
            videoUrl: "https://www.youtube.com/embed/rVqB8fQoKTo"
        }
    ]
};

async function fetchMovies(endpoint, fallbackData) {
    try {
        const response = await fetch(`${API_BASE_URL}/${endpoint}`);
        if (!response.ok) throw new Error("API Offline");
        return await response.json();
    } catch (err) {
        return fallbackData;
    }
}

function renderMovieCards(items, containerId) {
    const container = document.getElementById(containerId);
    if (!container) return;
    container.innerHTML = items.map(item => `
        <div class="movie-card" onclick="openVideoPlayer('${item.videoUrl}', '${item.title.replace(/'/g, "\'")}', '${item.desc ? item.desc.replace(/'/g, "\'") : ''}')">
            <div class="card-thumbnail">
                <img src="${item.img}" alt="${item.title}">
                <span class="card-tag">${item.tag}</span>
                <span class="card-episodes">${item.episodes}</span>
            </div>
            <div class="card-body">
                <div class="card-title">${item.title}</div>
                <div class="card-info">
                    <span><i class="fas fa-star star"></i> ${item.rate}</span>
                    <span>${item.year}</span>
                </div>
            </div>
        </div>
    `).join('');
}

function renderAudioCards(items, containerId) {
    const container = document.getElementById(containerId);
    if (!container) return;
    container.innerHTML = items.map(item => `
        <div class="audio-card" onclick="openVideoPlayer('${item.videoUrl}', '${item.title.replace(/'/g, "\'")}', '${item.author.replace(/'/g, "\'")}')">
            <div class="audio-thumb">
                <img src="${item.img}" alt="${item.title}">
            </div>
            <div class="audio-info">
                <div class="audio-title">${item.title}</div>
                <div class="audio-lecturer"><i class="fas fa-spa"></i> ${item.author}</div>
            </div>
        </div>
    `).join('');
}

function openVideoPlayer(url, title, desc) {
    const modal = document.getElementById('videoModal');
    const iframe = document.getElementById('videoIframe');
    iframe.src = url + "?autoplay=1";
    document.getElementById('modalTitle').innerText = title;
    document.getElementById('modalDesc').innerText = desc || "";
    modal.classList.add('active');
}

function closeVideoPlayer() {
    const modal = document.getElementById('videoModal');
    document.getElementById('videoIframe').src = "";
    modal.classList.remove('active');
}

document.addEventListener('DOMContentLoaded', async () => {
    const classics = await fetchMovies('movies/classics', mockData.classics);
    const animations = await fetchMovies('movies/animations', mockData.animations);
    const audios = await fetchMovies('movies/audios', mockData.audios);

    renderMovieCards(classics, 'classicMovies');
    renderMovieCards(animations, 'animationMovies');
    renderAudioCards(audios, 'audioSectionList');

    const searchInput = document.getElementById('searchInput');
    if (searchInput) {
        searchInput.addEventListener('input', (e) => {
            const query = e.target.value.toLowerCase().trim();
            renderMovieCards(classics.filter(m => m.title.toLowerCase().includes(query)), 'classicMovies');
            renderMovieCards(animations.filter(m => m.title.toLowerCase().includes(query)), 'animationMovies');
        });
    }
});
