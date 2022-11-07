# day12
Servlet&amp;JSP 수업내용

## 0_Servlet/JSP 개요
## 1_Servlet
## 2_JSP
### JSP란?
* JSP란, HTML형식 내에서 JAVA소스코드를 쓸 수 있음
* 서블릿에서 응답화면을 구현했던 복잡함을 보다 간단하게 해결 가능한 기술 <br>
=> JSP의 가장 큰 장점은 Servlet에서는 비즈니스로직처리에만 집중하고
* 프레젠테이션 로직 처리는 (응답화면을 만들어내는 뷰) JSP에서 집중할 수 있게끔 분리하는 것
### JSO 표현법
1. JSP 스크립팅 요소(Scripting Element) <br>
: JSP페이지에서 자바코드를 기술할 수 있게 해주는 기능
    1) 선언문 : &lt;%! %&gt; <br>
    변수나 메소드를 선언하기 위해 사용
    2) 스크립틀릿 : &lt;% %&gt; <br>
    JSP에서 자바코드를 기술하기 위한 가장 기본적인 표현법
    3) : &lt;%= %&gt; <br>
    자바에서 작성한 값(변수 또는 메소드호출)을 출력하기 위해 사용
2. 지시어 또는 지시자
* 자바에서 작성한 값(변수 또는 메소드호출)을 출력하기 위해 사용
* [ 표현법 ] : &lt;%@ page/include/taglib 속성="속성값" %&gt;
* &lt;%@ page/include/taglib 속성="속성값" %&gt;
* 페이지 지시어  : 현재 JSP페이지를 처리하는데 필요한 각종 속성들을 기술하는 부분
  + 페이지 지시어  : 현재 JSP페이지를 처리하는데 필요한 각종 속성들을 기술하는 부분
  + contentType : 웹브라우저가 받아볼 페이지의 형식, 인코딩 방식 지정
  + pageEncoding : JSP파일에 기록된 자바코드의 인코딩 방식 지정
  + import : 자바의 import구문과 같은 의미
  + errorPage : 해당 JSP상에 오류가 발생했을 경우 보여줄 에러페이지의 경로 지정

### POST방식으로 요청 후 응답페이지 받아보기
    1) 전달값 중에 한글이 있을 경우 인코딩 처리(POST방식일 경우)
    2) 요청 시 전달한 값을 뽑기 및 데이터 가공 처리 => 변수에 기록
    3) 요청처리
    4) 요청처리 후 사용자가 보게될 응답페이지 만들기 또는 JSP에게 위임
    + request의 attribute라는 영역에 응답페이지에 필요한 값 담기

    + RequestDispatcher 객체 생성(위임할 JSP파일의 경로 기술)
    + request.getRequestDispatcher() 호출하면 반환
    > RequestDispatcher view = request.getRequestDispatcher("views/05_ChickenPayment.jsp");
    + forward(request, response) 호출하여 넘겨주기
    > view.forward(request, response);
    
    .jsp파일 작성
    <%
    이 구문을 스크립틀릿(scriptlet)이라고 해서 HTML내에 자바코드를 쓸 수 있는 영역
    현재 이 jsp파일에서 필요한 데이터들 => request객체의 attribute영역에 담겨있음
    request.getAttribute("키값") : object
    > String nickName = (String)request.getAttribute("nickName"); // : object
    %>
## 3_SubwayStore
* 서버로 요청할 때 : 항상 form태그로 넘겼음(submit버튼)
* form 태그에 항상 있어야 하는 것 : action속성(어느 서블릿으로 보낼건가) / method속성(get/post)

