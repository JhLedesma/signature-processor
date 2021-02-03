package com.wenance.signatureprocessor.core.exception

import java.lang.RuntimeException

class ResourceNotFound(mjs: String) : RuntimeException(mjs)