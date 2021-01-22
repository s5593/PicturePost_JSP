<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">

<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.writeForm;
		
	if ( f.model_num.value == "") {
	    alert( "포스트번호를 입력해 주세요." );
	    f.post_num.focus();
		return false;
    }
	if ( f.model_name.value == "" ) {
		alert( "포스트이름을 입력해 주세요." );
		f.post_name.focus();
		return false;
	}
	if ( f.price.value == "" ) {
		alert( "카테고리를 입력해 주세요." );
		f.categoty.focus();
		return false;
	}
	if ( f.password.value == "" ) {
        alert( "비밀번호를 입력해 주세요" );
        f.password.focus();
        return false;
    }
	
    return true;
}
</SCRIPT>


</HEAD>
<BODY>

<form name="writeForm" method="post" action="${path}/front?key=post&methodName=insert" 
  onSubmit='return checkValid()' enctype="multipart/form-data">

<table align="center" cellpadding="5" cellspacing="2" width="600" border="1" >
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b> 상품 등록 </b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">포스트번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="post_num" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">포스트이름</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="post_name" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">카테고리</span></b></p>
        </td>
        <td width="450" height="20" >

<select name="category">
	<option value="">===선택===</option>
    <option value="humen">사람</option>
    <option value="animal">동물</option>
    <option value="scenery">풍경</option>
</select></td>
    </tr>    
     <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">사진첨부</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		 <input type="file" name="picture" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>
    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">
        		<input type=password name="password" size="12">(글 수정, 삭제시 필요합니다.)
        	   </span></b>
        </td>
    </tr>
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type=submit value=포스팅> 
        <input type=reset value=다시쓰기></span></b></td>
    </tr>
</table>

</form>

<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}">리스트로 돌아가기</a>&gt;</span></div>

<jsp:include page="../common/footer.jsp"/>
