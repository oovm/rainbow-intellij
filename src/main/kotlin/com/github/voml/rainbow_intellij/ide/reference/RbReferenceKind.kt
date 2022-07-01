package com.github.voml.rainbow_intellij.ide.reference

class RbReferenceKind(val name: String) {
    companion object {
        val CLASS = RbReferenceKind("class")
        val MODULE = RbReferenceKind("module")
        val CONSTANT = RbReferenceKind("constant")
        val VARIABLE = RbReferenceKind("variable")
        val METHOD = RbReferenceKind("method")
        val UNKNOWN = RbReferenceKind("unknown")
    }
}