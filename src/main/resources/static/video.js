const video = {
  getVideo: (name) => {
    const videoSource = document.getElementById('videoSource');
    videoSource.src = `/resource/videos/${name}`; // 비디오 소스 URL 설정
    document.getElementById('video').load(); // 새로운 소스를 로드
  }
  // ,getVideoNameFromPath: () => {
  //   const path = window.location.pathname;
  //   return path.substring(path.lastIndexOf('/') + 1);
  // }
}

// console.log(video.getVideoNameFromPath());
video.getVideo('video2.mp4');
