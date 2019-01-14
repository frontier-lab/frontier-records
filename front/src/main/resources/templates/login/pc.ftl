<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no, shrink-to-fit=no">
  <title>회원가입</title>
  <link rel="stylesheet" href="/static/pc/css/common.css">
  <link rel="stylesheet" href="/static/pc/css/member.css">
  <link rel="shortcut icon" type="image/x-icon" href="/static/img/favicon.ico">
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<div class="wrap typewhite">
  <!-- header -->
  <div class="header"><!-- [D]아래로 스크롤시 fixed 클래스명 추가, 위로 스크롤시 제거 -->
    <h1 class="logo"><a href="#">FRONTIER RECORDS</a></h1>
    <!-- 20180209 GNB 수정 -->
    <ul class="gnb_menu">
      <li class="tv"><a href="#">TV<sup>+</sup></a></li>
      <li class="story on"><a href="#">스토리</a></li>
    </ul>
    <!-- //20180209 GNB 수정 -->
    <ul class="option_btn">
      <li class="srch_opt"><!-- [D]하단에 검색하기 버튼 클릭시 on 클래스명 추가 -->
        <div class="srch_inp_box"><input type="text" title="검색어 입력" value="" class="srch_inp">
          <button type="button" class="sp srch_btn">검색하기</button>
        </div>
        <div class="srch_suggest_layer">
          <ul>
            <li><a href="#" class="keyword">
              <mark class="inp_word">다이</mark>
              어트</a></li>
            <li><a href="#" class="keyword">
              <mark class="inp_word">다이</mark>
              나믹듀오</a></li>
            <li><a href="#" class="keyword">
              <mark class="inp_word">다이</mark>
              어트운동</a></li>
            <li><a href="#" class="keyword">
              <mark class="inp_word">다이</mark>
              빙</a></li>
            <li><a href="#" class="keyword">
              <mark class="inp_word">다이</mark>
              이어트일기</a></li>
            <li><a href="#" class="keyword">
              <mark class="inp_word">다이</mark>
              어트</a></li>
            <li><a href="#" class="keyword">
              <mark class="inp_word">다이</mark>
              나믹듀오</a></li>
            <li><a href="#" class="keyword">
              <mark class="inp_word">다이</mark>
              소롯데마트갈등발화범다이소</a></li>
            <li><a href="#" class="keyword">
              <mark class="inp_word">다이</mark>
              빙</a></li>
            <li><a href="#" class="keyword">
              <mark class="inp_word">다이</mark>
              이어트일기</a></li>
          </ul>
        </div>
      </li>
      <li class="alarm_opt"><!-- [D]하단에 알람 버튼 클릭시 on 클래스명 추가 -->
        <button type="button" class="sp alarm_btn">알람<em class="sp">new</em></button><!-- [D]신규 알람 있는 경우 em 태그 추가 -->
      </li>
      <li class="slide_opt">
        <button type="button" class="sp slide_btn">슬라이드 메뉴</button>
      </li>
    </ul>
  </div>
  <!-- //header -->
  <!-- container -->
  <div class="container">
    <!-- content -->
    <div class="content signup_cnt">
      <h3 class="h3_tit">회원가입</h3>
      <div class="signup_content">
        <div class="profile_area">
          <img src="/static/img/profile.gif" class="thumb">
          <label for="uploadfile" class="sp profile_change">
            <input type="file" name="imagefile" id="uploadfile" class="profile_change_inp" title="프로필 사진 변경">
          </label>
        </div>
        <div class="nickname_area">
          <p class="tit">닉네임</p>
          <!-- 수정전 -->
          <div class="nickname_wrap info">
            <div class="nickname_box">
              <p class="nickname">일이삼사오육칠팔구십일이삼사오</p>
              <div class="btn_area">
                <button class="btn_edit">수정</button>
              </div>
            </div>
          </div>
          <!-- //수정전 -->
          <!-- 수정하기 -->
          <div class="nickname_wrap edit" style="display:none">
            <div class="nickname_box">
              <p class="nickname inp_wrap"><input type="" name="" class="inp_nickname" maxlength="15" value="일이삼사오육칠팔구십일이삼사오"></p>
              <!--div class="btn_area">
                <button class="btn_cancel">취소</button>
                <button class="btn_save">저장</button>
              </div-->
            </div>
            <ul class="nickname_guide">
              <li>한글, 영문, 숫자로 15자리까지 가능합니다.</li>
              <li>닉네임은 수정 가능하며, 댓글 입력 등에 노출됩니다.</li>
            </ul>
          </div>
          <!-- //수정하기 -->
          <!-- 에러 -->
          <div class="nickname_wrap error" style="display:none">
            <div class="nickname_box">
              <p class="nickname inp_wrap"><input type="" name="" class="inp_nickname" maxlength="15" value="일이삼사오육칠팔구십일이삼사오"></p>
              <!--<div class="btn_area">
                <button class="btn_cancel">취소</button>
                <button class="btn_save">저장</button>
              </div-->
            </div>
            <ul class="nickname_guide">
              <li>닉네임으로 사용하실 수 없습니다.</li>
              <li>닉네임은 한글, 영문, 숫자 15자로 설정할 수 있습니다.</li>
              <li>특수문자나 자음, 모음만은 사용 불가합니디.</li>
            </ul>
          </div>
          <!-- //에러 -->
        </div>
        <div class="terms_area">
          <button class="sp btn_allagree">전체 동의</button><!-- [D]클릭시 버튼에 on 클래스명 추가 -->
          <ul class="terms_lst">
            <li class="terms_service">
              <input type="checkbox" id="termsService" class="chk">
              <label for="termsService">LOOPIN 서비스이용약관에 동의합니다.<span class="essential">(필수)</span></label><!-- [D]클릭시 label에 on 클래스명 추가 -->
              <a href="#" class="terms_view">보기</a>
            </li>
            <li class="terms_privacy">
              <input type="checkbox" id="termsPrivacy" class="chk">
              <label for="termsPrivacy">LOOPIN 개인정보처리방침에 동의합니다.<span class="essential">(필수)</span></label>
              <a href="#" class="terms_view">보기</a>
            </li>
          </ul>
        </div>
        <div class="btn_area">
          <a href="#" class="btn_join">회원가입하기</a>
        </div>
      </div>
    </div>
    <!-- //content -->
  </div>
  <!-- //container -->
</div>
<div class="dimd"></div>
<!-- 마크업검수용 -->
<script type="text/javascript">
  // 회원가입
  $('.btn_allagree').on('click', function () {
    $('.btn_allagree').toggleClass('on');
  });
  $('.terms_service label').on('click', function () {
    $('.terms_service label').toggleClass('on');
  });
  $('.terms_privacy label').on('click', function () {
    $('.terms_privacy label').toggleClass('on');
  });
  $('.info').on('click', function () {
    $('.nickname_wrap').hide();
    $('.edit').show();
  });
  $('.edit').on('click', function () {
    $('.nickname_wrap').hide();
    $('.error').show();
  });
  $('.error').on('click', function () {
    $('.nickname_wrap').hide();
    $('.info').show();
  });
</script>
<!-- //마크업검수용 -->
</body>
</html>