<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Créer un webservice</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<style type="text/css">
		section {
		    padding: 10px;        
		}

		section > div {
		    padding: 5px;
		    width: 100%;
		}

		div.new {
		    background-color: rgb(230,230,230);
		    border-bottom: 1px dotted #ccc;
		    display: none;
		}

		input {
		    border: 1px solid #eee;
		    border-radius: 4px;
		    line-height: 1.5em;
		    padding: 4px;
		}

		a.rowDelete {
		    cursor: pointer;
		    padding-left: 9px;
		}
	</style>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	</head>
	<script type="text/javascript">function addRow(section, initRow) {
	    var newRow = initRow.clone().removeAttr('id').addClass('new').insertBefore(initRow),
	        deleteRow = $('<a class="rowDelete"><img src="http://i.imgur.com/ZSoHl.png"></a>');
	   
		    newRow
		        .append(deleteRow)
		        .on('click', 'a.rowDelete', function() {
		            removeRow(newRow);
		        })
		        .slideDown(300, function() {
		            $(this)
		                .find('input').focus();
		        })
		}
		        
		function removeRow(newRow) {
		    newRow
		        .slideUp(200, function() {
		            $(this)
		                .next('div:not(#initRow)')
		                    .find('input').focus()
		                    .end()
		                .end()
		                .remove();
		        });
		}

		$(function () {
		    var initRow = $('#initRow'),
		        section = initRow.parent('section');
		    
		    initRow.on('focus', 'input', function() {
		        addRow(section, initRow);
		    });
		});

	</script>
<body>


	<form class="form-horizontal">
	<fieldset>

	<!-- Form Name -->
	<legend>Créer un WebService</legend>

	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="name">Nom du service</label>  
	  <div class="col-md-4">
	  <input id="name" name="name" type="text" placeholder="" class="form-control input-md" required="">
	  <span class="help-block">Entrer le nom du webservice</span>  
	  </div>
	</div>

	<!-- Text input-->
	<div class="form-group">
		<label class="col-md-4 control-label" for="ip">IP</label>  
		<div class="col-md-4">
			<input id="ip" name="ip" type="text" placeholder="" class="form-control input-md" required="">
			<span class="help-block">Entrer l'IP du WebService</span>
		  	<section>
			    <div id="initRow">
			    	<input name="multifield" placeholder="Value">
			    </div>
			</section>
		</div>
	</div>

	</fieldset>
	</form>

</body>
</html>