package org.http4k.connect.kafka.httpproxy.model

typealias SendRecord = Triple<Long, Any?, Any>

operator fun Offset.inc() = Offset.of(value + 1)
operator fun Offset.plus(that: Offset) = Offset.of(value + that.value)
operator fun Offset.minus(that: Offset) = Offset.of(value - that.value)
