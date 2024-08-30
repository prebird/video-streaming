const video = {
  getVideo: (requestPrefix, name) => {
    const videoSource = document.getElementById('videoSource');
    videoSource.src = `http://localhost:7777/${requestPrefix}/videos/${name}`; // 비디오 소스 URL 설정
    document.getElementById('video').load(); // 새로운 소스를 로드
  }
}

