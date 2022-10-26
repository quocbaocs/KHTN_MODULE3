<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<div class="row">
	<h3 align="center" style="color: red;"><i>${msg}</i></h3>
		<div class="col-lg-4">
			<p>
				<i class="fas fa-map-marker-alt"></i> Địa chỉ <br /> <span>
					Thành phố hồ chí minh<br /> Việt Nam
				</span>
			</p>

			<p>
				<i class="fas fa-phone-alt"></i> Điện thoại <br /> <span>
					0565251368</span>
			</p>

			<p>
				<i class=" far fa-envelope"></i> General Support <br /> <span>quocbaole368@gmail.com</span>
			</p>
		</div>

		<div class="col-lg-8">
			<div class="inside-contact">
				<h2>Liên hệ</h2>
				<form action="sendmail" method="post">
					<p>Name *</p>
					<input id="txt_name" type="text" Required="required" size="50" name="txt_name">

					<p>Email *</p>
					<input id="txt_email" type="text" Required="required" size="50" name="txt_email">

					<p>Phone *</p>
					<input id="txt_phone" type="text" Required="required" size="50" name="txt_phone">

					<p>Subject *</p>
					<input id="txt_subject" type="text" Required="required" size="50" name="txt_subject">

					<p>Message *</p>
					<textarea id="txt_message" rows="4" cols="50" Required="required" name="txt_message"></textarea>
					<br> <input type="submit" id="btn_send" value="SEND">
				</form>
			</div>
		</div>
	</div>
</div>
