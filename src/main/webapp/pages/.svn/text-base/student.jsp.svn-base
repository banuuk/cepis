<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags"%>

<link
	href="${facesContext.externalContext.requestContextPath}/css/inettuts.css"
	rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/inettuts.js.css"
	rel="stylesheet" type="text/css" />
<link
	href="${facesContext.externalContext.requestContextPath}/css/home.css"
	rel="stylesheet" type="text/css" />
	
<f:subview id="student-cepis">	
	<h:form>
		<div id="text2">
			<div id="columns">
				<ul id="column1" class="column">
					<li class="widget color-white" id="advising">
						<div class="widget-head">
							<h3>Advising Manager</h3>
						</div>
						<div class="widget-content">
							<p>
								<table width="100%">
									<tbody>
										<tr valign="top">
											<td width="100%" valign="top">
												<div class="head" align="center">
													<h:commandButton value="Advising Appointments >"
													action="/pages/advising/index.jsp?faces-redirect=true"
													style="width:150px;height:25px;font-size:12px;"
													title="Advising Manager" />
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<br />
											</td>
										</tr>
										<tr>
											<td align="center">
												<table>
													<tr>
														<td>
															<div class="label">
																<font class="ws10" face="Tahoma" color="black">
																	<b>Available Options:</b>
																</font>
															</div>
															<ul>
																<li>
																	<font class="ws10" face="Tahoma" color="black">
																		Schedule an appointment
																	</font>
																</li>
																<li>
																	<font class="ws10" face="Tahoma" color="black">
																		View/edit/cancel an appointment.
																	</font>
																</li>
															</ul>
														</td>
													</tr>
												</table> 
												<br />
											</td>
										</tr>
									</tbody>
								</table>
							</p>
						</div>
					</li>
					<li class="widget color-white" id="account">
						<div class="widget-head">
							<h3>Account Manager</h3>
						</div>
						<div class="widget-content">
							<p>
								<table width="100%">
									<tbody>
										<tr valign="top">
											<td width="100%" valign="top">
												<div class="head" align="center">
													<h:commandButton value="Account Manager >"
													action="/pages/account/index.jsp?faces-redirect=true"
													style="width:125px;height:25px;font-size:12px;"
													title="Account Manager" />
												</div>
											</td>
										</tr>
										<tr>
											<td><br /></td>
										</tr>
										<tr>
											<td align="center">
												<table>
													<tr>
														<td>
															<div class="label">
																<font class="ws10" face="Tahoma" color="black">
																	<b>Available Options:</b>
																</font>
															</div>
															<ul>
																<li>
																	<font class="ws10" face="Tahoma" color="black">
																		View student account information
																	</font>
																</li>																
																<li>
																	<font class="ws10" face="Tahoma" color="black">
																		Add Email Address/Phone number
																		<br /> /Address details.
																	</font>
																</li>															
															</ul>
														</td>
													</tr>
												</table> <br />
											</td>
										</tr>
									</tbody>
								</table>
							</p>
						</div>
					</li>									
				</ul>

				<ul id="column2" class="column">
					
					<authz:authorize
						ifNotGranted="ROLE_ADMINISTRATOR,ROLE_DEVELOPER,ROLE_STUDENT_ACCOUNT_MANAGER_ADD,ROLE_STUDENT_ACCOUNT_MANAGER_EDIT,ROLE_STUDENT_ACCOUNT_MANAGER_VIEW,ROLE_ADVISOR,ROLE_ADVISING_MANAGER">
						<authz:authorize ifAnyGranted="ROLE_STUDENT">
							<li class="widget color-white" id="profile">
								<div class="widget-head">
									<h3>My Profile</h3>
								</div>
								<div class="widget-content">
									<p>
										<table width="100%">
											<tbody>
												<tr valign="top">
													<td width="100%" valign="top">
														<div class="head" align="center">
															<h:commandButton value="My Profile >" 
															action="/pages/ems/index.jsp?faces-redirect=true"
															style="width:125px;height:25px;font-size:12px;"
															title="My Profile" />
														</div>
													</td>
												</tr>
												<tr>
													<td><br /></td>
												</tr>
												<tr>
													<td align="center">
														<table>
															<tr>
																<td>
																	<div class="label">
																		<font class="ws10" face="Tahoma" color="black">
																			<b>Available Options:</b>
																		</font>
																	</div>
																	<ul>
																		<li>
																			<font class="ws10" face="Tahoma" color="black">
																				Demographic Information 
																			</font>
																		</li>
																		<li>
																			<font class="ws10" face="Tahoma" color="black">
																				Contact Details 
																			</font>
																		</li>
																		<li>
																			<font class="ws10" face="Tahoma" color="black">
																				Courses Taken 
																			</font>
																		</li>
																		<li>
																			<font class="ws10" face="Tahoma" color="black">
																				Recent Activities 
																			</font>
																		</li>
																		<li>
																			<font class="ws10" face="Tahoma" color="black">
																				Enrollment Management System.
																			</font>
																		</li>
																	</ul>
																</td>
															</tr>
														</table> <br />
													</td>
												</tr>
											</tbody>
										</table>
									</p>
								</div>
							</li>
						</authz:authorize>
					</authz:authorize>					
				</ul>
				<ul id="column3" class="column">
					<li class="widget color-fb" id="facebook">
						<div class="widget-head">
							<h3>facebook Stream</h3>
						</div>
						<div class="widget-content">
							<div class="fb-like-box" style="width: 100%"
								data-href="http://www.facebook.com/pages/College-of-Education-Student-Services-University-of-Kentucky/144658132249807"
								data-height="425" data-show-faces="false"
								data-border-color="white" data-stream="true" data-header="false">
							</div>
						</div>
					</li>					
				</ul>
			</div>
		</div>	
		
		<script type="text/javascript"
			src="${facesContext.externalContext.requestContextPath}/js/jquery-1.2.6.min.js"></script>
		<script type="text/javascript"
			src="${facesContext.externalContext.requestContextPath}/js/jquery-ui-personalized-1.6rc2.min.js"></script>
		<script type="text/javascript"
			src="${facesContext.externalContext.requestContextPath}/js/cookie.jquery.js"></script>
		<script type="text/javascript"
			src="${facesContext.externalContext.requestContextPath}/js/inettuts.js"></script>
		<script type="text/javascript"
			src="${facesContext.externalContext.requestContextPath}/js/jquery.zweatherfeed.min.js"></script>
		
	</h:form>
</f:subview>