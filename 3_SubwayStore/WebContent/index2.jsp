<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서브웨이</title>
</head>
<body>
    <h1>서브웨이에 오신 것을 환영합니다.</h1>

    <h2>오늘의 날짜</h2>

    
    <br>

    <form action="/3_SubwayStore/orderSubway.do" method="get">
    주문정보
        <fieldset>주문자 정보
            <table>
                <tr>
                    <th>닉네임</th>
                    <th><input type="text" required name="nickName"></th>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td><input type="text" required name="phone"></td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td><input type="text" required name="address"></td>
                </tr>
                <tr>
                    <th>요청사항</th>
                    <td><textarea style="resize : none;" name="message"></textarea></td>
                </tr>
            </table>
        </fieldset>

        <fieldset>주문 정보
            <legend>주문 정보</legend>

            <table>
                <tr>메뉴</tr>
                <td>
                    <select name="menu">
                        <option>에그마요</option>
                        <option>햄</option>
                        <option>참치</option>
                        <option>미트볼</option>
                        <option>비엘티</option>
                        <option>이탈리안 비엠티</option>
                    </select>
                </td>
                <tr>사이즈</tr>
                <td>
                    <input type="radio" value="15cm" name="size" checked>15cm
                    <input type="radio" value="30cm" name="size">30cm
                </td>
                <tr>빵</tr>
                <td>
                    <input type="radio" value="화이트" name="bread" checked>화이트
                    <input type="radio" value="파마산 오레가노" name="bread">파마산 오레가노
                    <input type="radio" value="위트" name="bread">위트
                    <input type="radio" value="허니오트" name="bread">허니오트
                    <input type="radio" value="하티" name="bread">하티
                    <input type="radio" value="플랫브래드" name="bread">플랫브래드
                </td>
                <tr>치즈</tr>
                <td>
                    <input type="radio" value="아메리칸치즈" name="cheese" checked>아메리칸치즈
                    <input type="radio" value="슈레드치즈" name="cheese">슈레드치즈
                    <input type="radio" value="모차렐라치즈" name="cheese">모차렐라치즈
                    <input type="radio" value="치즈 제외" name="cheese">치즈 제외
                </td>
                <tr>재료 추가선택(최대7개)</tr>
                <td>
                    <input type="checkbox" value="미트추가" name="additional selection">미트추가
                    <input type="checkbox" value="에그마요 추가" name="additional selection">에그마요 추가
                    <input type="checkbox" value="페퍼로니 추가" name="additional selection">페퍼로니 추가
                    <input type="checkbox" value="베이컨 추가" name="additional selection">베이컨 추가
                    <input type="checkbox" value="아보카도 추가" name="additional selection">아보카도 추가
                    <input type="checkbox" value="오믈렛 추가" name="additional selection">오믈렛 추가
                    <input type="checkbox" value="치즈(동일치즈)추가" name="additional selection">치즈(동일치즈)추가
                </td>
                <tr>빵/미트 토스팅 선택</tr>
                <td>
                    <input type="radio" value="토스팅" name="">
                    <input type="radio" value="토스팅" name="">
                </td>
            </table>


        </fieldset>

        

    </form>

</body>
</html>