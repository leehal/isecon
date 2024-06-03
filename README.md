
  <div>
    <img src="https://github.com/leehal/isecon/assets/129915370/0f81db2a-98db-49e4-9691-e47113ded62a">


  </div>
 <div  align=center>
   <p>📚 Tech Stack 📚 </p>
      <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white">
      <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">
      <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white">
<img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white">
   <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white">
   <img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white">
    <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white">
  </div>
  <div>
   <h2><span>🚩</span>프로젝트 소개</h2>
    <p>니모를 찾아조!는 풀스택 개발 취준생 4명이 만든 프로젝트로 반려동물을 분양 및 입양 글을 자유롭게 적어 새로운 가족을 만날 수 있게 돕는 프로젝트 입니다. 해당 프로젝트는 스프링부트와 리액트를 공부하기 앞서 스프링 MVC 패턴의 이해와 DB 공부를 중심으로 만들어진 프로젝트로 이후의 발전을 기대해주세요!😊</p>
  </div>
  <div>
    <h2><span>💿</span>Spring MVC</h2>
    <p>
      MVC 패턴은 어플리케이션을 세 가지 영역, 즉 <b>모델(Model)</b>,  <b>뷰(View)</b> , <b>컨트롤러(Controller)</b>로 구분하여 작업을 분리하는 웹 어플리케이션 개발 방법론입니다. 저희는 이번 Model은 JDBC를 선택했고 그 중 Oracle DB를 사용했습니다.
    </p>
    <p>
      <img src="https://github.com/limfarmer/find_nimo/assets/129915370/5c44308c-c302-448c-9467-c42cee2bb962">
<!--       <img src="https://github.com/limfarmer/find_nimo/assets/129915370/2567fa7f-0563-49f3-bf10-a5dbc24b90de"> -->
    </p>
  </div>
  <div>
    <h2>🐱‍👤프로젝트 기능 소개</h2>
<!--     // -->
    <p>
      <h3>1. 로그인 페이지</h3>
      <h5>1. 로그인</h5>
      <p>
      첫 화면 페이지입니다. 아이디와 비밀번호를 입력받고 아이디와 비밀번호가 일치할 경우 세션에 해당 아이디를 저장하는 방식을 통해 구현 했습니다.
      </p>
      <img src="https://github.com/limfarmer/find_nimo/assets/129915370/1be9db82-e99d-407b-ab40-e4fb9f4e8ad3">
    <h5>2. 회원가입</h5>
    <p>
      아이디와 비밀번호가 없을 시 로그인 페이지 하단의 회원가입을 누르면 회원가입 페이지로 이동하여 회원가입을 진행할 수 있습니다.
    </p>
    <img src="https://github.com/limfarmer/find_nimo/assets/129915370/25b5f74f-52b6-4f38-b163-1d11b9acf7f9">
    </p>
<!--     // -->
    <p>
      <h3>2. 메인 페이지</h3>
      <p>
        로그인 후 이동하는 페이지로 <b>Header</b>와 <B>Footer</B>를 적용해 다른 페이지로 이동 할 수 있게 구현 했습니다. <B>Footer</B>에는 로그아웃 기능을 넣어 로그아웃시 세션에 저장된 아이디 값을 지우고 다시 로그인 페이지로 이동하게 됩니다.
      </p>
      <img src="https://github.com/limfarmer/find_nimo/assets/129915370/cc9f873d-969c-4423-890f-6ec51d19736d">
    </p>
<!--     // -->
    <p>
      <h3>3. 분양 페이지</h3>
      <h5>1. 분양 전체 페이지</h5>
      <p>
        아직 분양이 안된 반려동물의 전체 리스트를 보여주는 페이지로 제목을 클릭 시 해당 글의 상세 페이지로 이동하게 됩니다.
      </p>
      <img src="https://github.com/limfarmer/find_nimo/assets/129915370/522ace50-74c7-4f83-8e10-eac99fa997b0">
  <h5>2. 분양 상세 페이지</h5>
    <p>
      상세페이지 하단의 분양받기 버튼을 클릭시 분양이 완료되어 전체페이지에 더이상 보이지 않으며 마이페이지의 내가 분양한 리스트에 추가가 됩니다.
    </p>
    <img src="https://github.com/limfarmer/find_nimo/assets/129915370/07fde7b1-9eeb-4d58-b0bf-4f9b2da958cd">  
  </p>
<!--     // -->
    <p>
    <h3>4. 후기 페이지</h3>
      <p>
        분양이 된 동물들 중 입양자가 쓴 후기 전체 리스트를 보여주는 페이지입니다. 제목을 클릭 시 후기 상세페이지로 이동하고 하단의 뒤로가기 클릭 시 다시 후기페이지로 이동하게 됩니다.
      </p>
      <img src="https://github.com/limfarmer/find_nimo/assets/129915370/77a0751e-58da-4f09-a1cf-4ecb4b75dd2f">
    </p>
<!--     // -->
    <p>
      <h3>5. 마이 페이지</h3>
      <h5>1. 마이 페이지</h5>
      <p>
        <b>header</b>의 마이페이지 클릭 시 보여지는 페이지입니다. 4개의 섹션으로 나누어져 각각의 페이지로 이동하게 됩니다.
      </p>
      <img src="https://github.com/limfarmer/find_nimo/assets/129915370/aaabb065-c646-4dd2-a3b2-57496d05c360">
  <h5>2. 회원 정보 수정</h5>
    <p>
      수정 전 정보를 보여주며 수정 할 수 있게 합니다. 하단의 수정완료 버튼 클릭시 수정이 됩니다
    </p>
    <img src="https://github.com/limfarmer/find_nimo/assets/129915370/d4559a2b-aac3-44fd-8df4-e978ea9bd0ba">
    <h5>3. 나의 분양 게시판</h5>
    <p>
      내가 분양한 반려동물들의 전체 리스트는 보여주는 페이지입니다. 후기등록을 누르면 후기 등록 페이지로 이동하며 정보 입력 후 후기등록 버튼을 누르면 후기가 등록되어 나의 후기 게시판과 후기 페이지에 추가 됩니다.
    </p>
    <img src="https://github.com/limfarmer/find_nimo/assets/129915370/0473dc97-5770-49f2-87c9-c98ba98d77da">
    <h5>4. 나의 후기 게시판</h5>
    <p>
      내가 등록한 후기글만 보여주는 게시판입니다. 제목을 클릭 시 해당 분양글의 상세페이지로 이동하게 됩니다.
    </p>
    <img src="https://github.com/limfarmer/find_nimo/assets/129915370/90e1b874-be43-4537-b7ad-85e23a6ee7ae">
    <h5>5. 회원 탈퇴</h5>
    <p>
      회원탈퇴 페이지는 비밀번호를 한 번 더 입력하고 비밀번호가 맞을 경우 탈퇴가 가능합니다. 탈퇴 성공시 로그인 페이지로 이동되고 비밀번호가 틀릴시 다시 마이페이지로 이동됩니다.
    </p>
    <img src="https://github.com/limfarmer/find_nimo/assets/129915370/fcccccd0-b6ae-4fb6-b35e-486973703ef5">
  </p>
  </div>
  <div>
    <h2>😎팀원</h2>
    <p>
<table>
  <tr>
    <td><a href="https://github.com/limfarmer"><img src="https://avatars.githubusercontent.com/u/129802296?v=4" width="150" height="150"/></a></td>
    <td><a href="https://github.com/lhw9097"><img src="https://avatars.githubusercontent.com/u/161571595?v=4" width="150" height="150"/></a></td>
    <td><a href="https://github.com/tmddyddl"><img src="https://avatars.githubusercontent.com/u/162107516?v=4" width="150" height="150"/></a></td>
    <td><a href="https://github.com/leehal"><img src="https://avatars.githubusercontent.com/u/129915370?v=4" width="150" height="150"/></a></td>
  </tr>
  <tr>
    <td><a href="https://github.com/limfarmer">@limfarmer</a></td>
    <td><a href="https://github.com/lhw9097">@lhw9097</a></td>
    <td><a href="https://github.com/tmddyddl">@tmddyddl</a></td>
    <td><a href="https://github.com/leehal">@leehal</a></td>
  </tr>
</table>
    </p>
  </div>
<!-- <img src="https://github.com/limfarmer/find_nimo/assets/129915370/13e91c1d-98e6-4f6f-9ec8-a9c92fa2cd09"> -->


