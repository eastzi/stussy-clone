package com.stissy.clone.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class,
				ValidationGroups.NotBlankGroup.class, 
				ValidationGroups.SizeCheckGroup.class,
				ValidationGroups.PatternCheckGroup.class})
public interface ValidationSequence {

}
