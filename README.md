# [백엔드 관통 10조] ✈️ Enjoy Trip!
바쁘고 지친 하루 하루, 아무런 걱정없이 여행을 떠나보세요.

# 🎄 폴더 구조
```
📦main
 ┣ 📂java
 ┃ ┗ 📂com
 ┃ ┃ ┗ 📂ssafy
 ┃ ┃ ┃ ┗ 📂project
 ┃ ┃ ┃ ┃ ┗ 📂enjoyTrip
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommunityController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FavoriteController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MapController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MemberController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dao
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommunityDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommunityDaoImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FavoriteDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FavoriteDaoImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MemberDaoImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂map
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dao
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttractionInfoDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttractionInfoDaoImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GugunDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GugunDaoImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SidoDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SidoDaoImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttractionInfoService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttractionInfoServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GugunService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GugunServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SidoService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SidoServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttractionInfo.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Gugun.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Sido.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommunityService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommunityServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FavoriteService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FavoriteServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MemberServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Community.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Favorite.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Member.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂util
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DBUtil.java
 ┗ 📂webapp
 ┃ ┣ 📂components
 ┃ ┃ ┣ 📜footer.jsp
 ┃ ┃ ┣ 📜header.jsp
 ┃ ┃ ┗ 📜modal.jsp
 ┃ ┣ 📂META-INF
 ┃ ┃ ┗ 📜MANIFEST.MF
 ┃ ┣ 📂resources
 ┃ ┃ ┣ 📂css
 ┃ ┃ ┃ ┣ 📜community.css
 ┃ ┃ ┃ ┣ 📜index.css
 ┃ ┃ ┃ ┣ 📜login.css
 ┃ ┃ ┃ ┣ 📜mainpage.css
 ┃ ┃ ┃ ┣ 📜mypage.css
 ┃ ┃ ┃ ┗ 📜signup.css
 ┃ ┃ ┣ 📂images
 ┃ ┃ ┃ ┣ 📜background.png
 ┃ ┃ ┃ ┣ 📜empty_star.svg
 ┃ ┃ ┃ ┣ 📜full_star.svg
 ┃ ┃ ┃ ┣ 📜logo.svg
 ┃ ┃ ┃ ┗ 📜noimage.png
 ┃ ┃ ┗ 📂js
 ┃ ┃ ┃ ┣ 📜community.js
 ┃ ┃ ┃ ┣ 📜components.js
 ┃ ┃ ┃ ┣ 📜kakaomap.js
 ┃ ┃ ┃ ┣ 📜mainpage.js
 ┃ ┃ ┃ ┣ 📜mypage.js
 ┃ ┃ ┃ ┗ 📜signpage.js
 ┃ ┣ 📜community.jsp
 ┃ ┣ 📜index.jsp
 ┃ ┣ 📜main.jsp
 ┃ ┣ 📜mypage.jsp
 ┃ ┣ 📜signup.jsp
 ┃ ┗ 📜test.jsp

```

# 📺 화면 구성
1. 로그인 & 회원가입 
   - 로그인 또는 회원가입을 할 수 있는 페이지
    - 로그인을 시도 했을 때 가입되지 않은 회원이라면 회원가입 페이지로 이동
    - 회원 가입을 완료하면 자동으로 로그인 화면으로 전환 됨
<br />

2. 메인페이지
    - 지도를 기반으로 내가 검색한 여행지 정보를 알 수 있는 페이지
    - 지도의 가장 첫 좌표는 우리 대전 싸피 교육장 ㅎㅎ (삼성 화재 유성캠퍼스)
    - 지역, 키워드 기반 검색 가능, 지역은 대분류와 소분류가 있는데 대분류는 필수지만 소분류는 없어도 검색 가능(ex. 대구 - null - 카페 검색 가능)
    - 검색 결과는 지도의 좌표와 지도 아래 부분에 카드 형태로 뜨고, 카드를 클릭하면 해당 장소로 지도가 이동함 + 카드를 호버하면 여행지 제목과 장소를 미리 볼 수 있다!
    - 빈 별 아이콘을 누르면 꽉 찬 별로 변경되고, 지도에서도 즐겨찾기가 표시 됨
  
<br />

3. 마이페이지
   - 프로필을 관리하고 즐겨찾기 한 여행지를 볼 수 있어서 여행 계획을 세울 수 있는 페이지
   - 즐겨찾기 한 여행지가 뜸
   - 마이페이지에서 즐겨찾기를 해제할 수 있다
   - 프로필 사진을 변경할 수 있다 (=> 헤더에도 똑같이 적용됨) ??
   - 로그아웃, 회원 탈퇴 기능

<br />

4. 커뮤니티
   - 여행 후 후기를 볼 수 있는 커뮤니티
   - 내가 다녀온 여행지에 대해 후기를 작성할 수 있다.
   - 사람들이 작성한 후기들을 볼 수 있다.
   - 내가 작성한 리뷰를 삭제할 수 있다.

<br />

5. 공통
   - 헤더를 통해 웹 사이트에서 이용할 수 있는 메뉴들을 표현
     - 헤더의 로고를 클릭하면 메인 페이지로 이동
     - 헤더의 프로필 부분을 클릭하면 마이 페이지로 이동
   - 푸터의 "SSAFY" 부분을 클릭하면 싸피 홈페이지가 새 창에 뜸
   - ContactUs를 클릭하면 개발자의 정보가 담긴 모달창이 뜸

<br />

# 🖥️ 화면 캡쳐
## 1. 로그인 & 회원가입 
   #### 로그인 또는 회원가입을 할 수 있는 페이지
![로그인 화면](./images/image.png)
![회원가입 화면](./images/image-2.png)
   #### 로그인을 시도 했을 때 가입되지 않은 회원이라면 회원가입 페이지로 이동
  !["회원 정보가 없습니다! 회원 가입 하시겠어요?" alert 창](./images/image-77.png)

  여기서 확인을 누르면 회원가입 화면이 뜸.
<br />

## 2. 메인페이지
  #### 지도를 기반으로 내가 검색한 여행지 정보를 알 수 있는 페이지
  *지도의 가장 첫 좌표는 우리 대전 싸피 교육장 ㅎㅎ (삼성 화재 유성캠퍼스)
  ![alt text](./images/image-7.png)
  #### 지역, 키워드 기반 검색 가능, 지역은 대분류와 소분류가 있는데 대분류는 필수지만 소분류는 없어도 검색 가능(ex. 대구 - null - 카페 검색 가능)
  ![alt text](./images/image-8.png)

  당연히 대분류 - 소분류 - 키워드 모두 있어도 검색할 수 있음!

  ![alt text](./images/image-12.png)
  #### 검색 결과는 지도의 좌표와 지도 아래 부분에 카드 형태로 뜨고, 카드를 클릭하면 해당 장소로 지도가 이동함
  ![alt text](./images/image-11.png)
  ![alt text](./images/image-9.png)
  ![alt text](./images/image-10.png) 
  
  +카드를 hover하면 여행지의 제목과 장소를 알려준다!
  #### 빈 별 아이콘을 누르면 꽉 찬 별로 변경되고, 지도에서도 즐겨찾기가 표시 됨
  ![alt text](./images/image-13.png)
  ![alt text](./images/image-14.png)
  (취소도 가능)

<br />

## 3. 마이페이지
  #### 프로필을 관리하고 즐겨찾기 한 여행지를 볼 수 있어서 여행 계획을 세울 수 있는 페이지
  ![alt text](./images/image-15.png)
  #### 즐겨찾기 한 여행지가 뜸
  ![alt text](./images/image-16.png)
  
  내가 즐겨찾기 표시했던 여행지들 (똑같이 hover시 제목과 장소를 볼 수 있다.)
  #### 마이페이지에서 즐겨찾기를 해제할 수 있다
  ![alt text](images/image-17.png)

  별 아이콘을 누르면 즐겨찾기가 해제되어 없어진다.

  #### 마이페이지 즐겨찾기 목록에서 후기를 작성할 수 있다
   ![alt text](./images/image-82.png)
  #### 로그아웃, 회원 탈퇴 기능
  ![alt text](images/image-85.png)
  
  ![alt text](images/image-79.png)

  회원탈퇴를 누르면 비밀번호 입력 모달 창이 뜨고 확인을 누르면 회원탈퇴가 된 후 로그인 페이지로 이동한다.
  ![alt text](images/image-78.png)

  비밀번호가 틀리면 메시지를 준다.
  
## 4. 커뮤니티
   #### 여행지에 대한 리뷰를 작성하고 후기를 볼 수 있는 페이지
   ![alt text](./images/image-80.png)
   #### 리뷰를 클릭하면 상세 글을 볼 수 있다
   ![alt text](./images/image-81.png)
   #### 리뷰를 삭제할 수 있다.
   ![alt text](./images/image-90.png)
   ![alt text](./images/image-91.png)

<br />

## 5. 공통
  #### 헤더를 통해 웹 사이트에서 이용할 수 있는 메뉴들을 표현
     - 헤더의 로고를 클릭하면 메인 페이지로 이동
     - 헤더의 프로필 부분을 클릭하면 마이 페이지로 이동
  #### - 푸터의 "SSAFY" 부분을 클릭하면 싸피 홈페이지가 새 창에 뜸
  #### - ContactUs를 클릭하면 개발자의 정보가 담긴 모달창이 뜸
  ![alt text](./images/image-23.png)
  많관부🤍

