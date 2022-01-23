<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 우편번호 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- datapicker -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
  	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
</head>
<body>

	<h2>회원가입</h2>
  	<p>The form below contains two input elements; one of type text and one of type password:</p>
  	<form class="container signup" action="<%= request.getContextPath()%>/signup" method="post">
		<h1 class="title text-center">회원가입</h1>
		<div class="box" style="height: 100px; border: 1px solid black;">약관내용</div>
		<div class="form-group">
			<!-- 성별 -->
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="checkbox" class="form-check-input" name="agree">동의합니다
				</label>
			</div>
			
		</div>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="아이디" name="me_id">
			<input type="password" class="form-control" placeholder="비밀번호" name="me_pw">
			<input type="password" class="form-control" placeholder="비밀번호확인" name="pw2">
			<input type="text" class="form-control" placeholder="이름" name="me_name">
			<input type="text" class="form-control" placeholder="생년월일" name="me_birth" id="birth">
			<input type="text" id="phone" placeholder="핸드폰번호('-'포함 13자리)" name="me_phone"class="form-control">
			<div class="form-group">
				<!-- 성별 -->
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="radio" class="form-check-input" name="me_gender" value="female">여성
					</label>
				</div>
				<div class="form-check-inline">
					<label class="form-check-label">
						<input type="radio" class="form-check-input" name="me_gender" value="male">남성
					</label>
				</div>
			</div>
			<div class="form-group">
				<!-- 주소 -->
				<div class="form-inline">
					<input type="text" id="postcode" placeholder="우편번호" class="form-control col-6"> 
					<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="form-control col-6">
				</div>
				<input type="text" id="address" placeholder="주소" class="form-control mb-2">
				<input type="text" id="detailAddress" placeholder="상세주소" class="form-control mn-2">
				<input type="hidden" name="me_address">
				
			</div>
			<button class="btn btn-outline-success col-12" id="btn">회원가입</button>
		</div>
	</form>
	
	<script>
		$(function(){
			//생년월일
			$("#birth").datepicker();
			$("#birth").datepicker( "option", "dateFormat", "yy-mm-dd" );
			/*
			이건왜안되는거지ㅜ
			$("#birth").datepicker({
				changeMonth: true,
			    changeYear: true,
			    "option", "dateFormat", "yy-mm-dd"
			});*/

			//항목 기입
			let id, pw, pw2, name, gender, birth, phone;
			let warnings = '';

			$('form').submit(function(){
				id = $('[name=me_id]').val();
				pw = $('[name=me_pw]').val();
				pw2 = $('[name=pw2]').val();
				name = $('[name=me_name]').val();
				birth = $('[name=me_birth]').val();
				birth = $('[name=me_phone]').val();
				let genderObj = $('[name=me_gender]:checked');
				//선택된 성별이 없으면 체크된 내용의 길이가 0일것이므로 ''을 반환
				gender = genderObj.length == 0 ? '' : genderObj.val();

				let isAgree = $('[name=agree]').is(':checked');
				// console.log(isAgree);
				if(!isAgree){
					alert('동의에 체크해야합니다.');
					$('[name=agree]').focus();
					return false;
				}
				if(id==''){alert('아이디를 입력하세요'); $('[name=me_id]').focus(); return false;}
				if(pw==''){alert('비밀번호를 입력하세요'); $('[name=me_pw]').focus(); return false;}
				if(pw2!=pw){alert('비밀번호가 일치하지않습니다.'); $('[name=pw2]').focus(); return false;}
				if(name==''){alert('이름을 입력하세요'); $('[name=me_name]').focus(); return false;}
				if(birth==''){alert('생년월일을 입력하세요'); $('[name=me_birth]').focus(); return false;}
				if(gender==''){alert('성별을 선택하세요'); $('[name=me_gender]').focus(); return false;}
				console.log('end!');

				let address = $('#address').val() + ' ' +$('#detailAddress').val();
				$('[name=me_address]').val(address);
				
			})
		});
			

//address
function execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if(data.userSelectedType === 'R'){
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
						extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if(data.buildingName !== '' && data.apartment === 'Y'){
						extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if(extraAddr !== ''){
						extraAddr = ' (' + extraAddr + ')';
				}
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('postcode').value = data.zonecode;
			document.getElementById("address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("detailAddress").focus();
		}
	}).open();
	}
	</script>
</div>
</body>
</html>