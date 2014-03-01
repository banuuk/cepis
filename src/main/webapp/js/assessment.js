
jQuery('.stdSource').change(
		function() {
			var stdId = jQuery(this).attr('id');
			var stdSearchStr = 'select[id^="'
					+ stdId.substring(0, (stdId.length - 12)) + '"]';
			var stdSetFinalScoreId = 'select[id="'
					+ stdId.substring(0, (stdId.length - 22))
					+ 'stdSetFinalScore"]';
			var sum = 0;
			var count = 0;
			var finalScore = 0;
			// Show animated change
			jQuery(stdSetFinalScoreId).fadeTo("slow", 0.33);
			jQuery(stdSearchStr).each(function() {
				var stdSetValue = parseInt(jQuery(this).val());
				if (stdSetValue > 0) {
					count = count + 1;
					sum = sum + stdSetValue;
				}
			});

			if (count != 0) {
				finalScore = (sum / count);
			}
			jQuery(stdSetFinalScoreId).val(Math.round(finalScore));
			jQuery(stdSetFinalScoreId).fadeTo("slow", 1);
			jQuery(stdSetFinalScoreId).change();
		});
jQuery('.stdSetTarget').change(
		function() {
			var stdSetFinalScoreId = jQuery(this).attr('id');
			var stdSetFinalScoreStr = 'select[id^="'
					+ stdSetFinalScoreId.substring(0,
							(stdSetFinalScoreId.length - 20))
					+ '"][id$="stdSetFinalScore"]';
			var stdSetComputedScoreId = 'span[id="'
					+ stdSetFinalScoreId.substring(0,
							(stdSetFinalScoreId.length - 20))
					+ 'computedAssessmentScore"]';
			var sum = 0;
			var count = 0;
			var finalScore = 0;
			jQuery(stdSetComputedScoreId).fadeTo("slow", 0.33);
			jQuery(stdSetFinalScoreStr).each(function() {
				var stdSetFinalScoreValue = parseInt(jQuery(this).val());
				if (stdSetFinalScoreValue > 0) {
					count = count + 1;
					sum = sum + stdSetFinalScoreValue;
				}
			});

			if (count != 0) {
				finalScore = (sum / count);
			}
			jQuery(stdSetComputedScoreId).html(Math.round(finalScore));
			jQuery(stdSetComputedScoreId).fadeTo("slow", 1);
		});
jQuery('.resetAssessment').click(
		function() {
			var resetButtonId = jQuery(this).attr('id');
			var assessmentCompSearchStr = '[id^="'
					+ resetButtonId.substring(0, (resetButtonId.length - 10))
					+ '"]';
			jQuery('div' + assessmentCompSearchStr).fadeTo("slow", 0.33);
			jQuery('select' + assessmentCompSearchStr).each(function() {
				jQuery(this).val(0);
			});
			jQuery(
					'span' + assessmentCompSearchStr
							+ 'id$="computedAssessmentScore"').html('0');
			jQuery('div' + assessmentCompSearchStr).fadeTo("slow", 1);

		});
jQuery('.copyAssessment').click(
		function() {
			var copyButtonId = jQuery(this).attr('id');
			var currentAssessProfileStr = '[id^="'
					+ copyButtonId.substring(0, (copyButtonId.length - 10))
					+ '"]';

		});
