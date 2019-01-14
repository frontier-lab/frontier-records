<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no, shrink-to-fit=no">
  <title>회원가입</title>
  <link rel="stylesheet" href="/static/mobile/css/common.css">
  <link rel="stylesheet" href="/static/mobile/css/member.css">
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<div class="wrap signup_cnt">
  <!-- header -->
  <div class="header">
    <h1 class="h1_tit">회원가입</h1>
  </div>
  <!-- //header -->
  <!-- container -->
  <div class="container">
    <!-- content -->
    <div class="content">
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
              <p class="nickname">a34243234</p>
              <div class="btn_area">
                <button class="btn_edit">수정</button>
              </div>
            </div>
          </div>
          <!-- //수정전 -->
          <!-- 수정하기 -->
          <div class="nickname_wrap edit" style="display:none">
            <div class="nickname_box">
              <p class="nickname inp_wrap"><input type="text" name="" maxlength="15" class="inp_nickname" title="닉네임" placeholder="" value="일이삼사오육칠팔구십일이삼사오"></p>
              <!-- 20180206 삭제 div class="btn_area">
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
          <!-- 에러 20180207 추가 -->
          <div class="nickname_wrap error" style="display:none">
            <div class="nickname_box">
              <p class="nickname inp_wrap"><input type="" name="" class="inp_nickname"></p>
            </div>
            <ul class="nickname_guide">
              <li class="error">이미 중복된 닉네임입니다.</li><!-- 강조 문구 error 클래스 추가 -->
              <li>닉네임은 한글, 영문, 숫자 15자로 설정할 수 있습니다.</li>
              <li>특수문자나 자음, 모음만은 사용 불가합니디.</li>
            </ul>
          </div>
          <!-- //에러 -->

        </div>
        <div class="terms_area">
          <button class="sp btn_allagree"><span class="sp blt_allagree"></span>전체 동의</button><!-- [D]클릭시 button 태그에 on 클래스명 추가 -->
          <ul class="terms_lst">
            <li class="terms_service">
              <input type="checkbox" id="termsService" class="chk">
              <label for="termsService" class="on">AMP 서비스이용약관에 동의합니다.<span class="essential">(필수)</span></label><!-- [D]클릭시 label에 on 클래스명 추가 -->
              <a href="#" class="terms_view">보기</a>
            </li>
            <li class="terms_privacy">
              <input type="checkbox" id="termsPrivacy" class="chk">
              <label for="termsPrivacy">AMP 개인정보처리방침에 동의합니다.<span class="essential">(필수)</span></label>
              <a href="#" class="terms_view">보기</a>
            </li>
          </ul>
        </div>
        <a href="#" class="btn_join">회원가입하기</a>
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

  $('.btn_allagree').on('click', function () {
    $('.btn_allagree').toggleClass('on');
  });
  $('.terms_service label').on('click', function () {
    $('.terms_service label').toggleClass('on');
  });
  $('.terms_privacy label').on('click', function () {
    $('.terms_privacy label').toggleClass('on');
  });

</script>
<!-- //마크업검수용 -->
</body>
</html>