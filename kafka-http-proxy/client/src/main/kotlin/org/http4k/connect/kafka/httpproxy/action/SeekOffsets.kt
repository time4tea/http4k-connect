package org.http4k.connect.kafka.httpproxy.action

import org.http4k.connect.Http4kConnectAction
import org.http4k.connect.kClass
import org.http4k.connect.kafka.httpproxy.KafkaHttpProxyMoshi.auto
import org.http4k.connect.kafka.httpproxy.model.ConsumerGroup
import org.http4k.connect.kafka.httpproxy.model.ConsumerInstanceId
import org.http4k.connect.kafka.httpproxy.model.SeekOffset
import org.http4k.connect.kafka.httpproxy.model.SeekOffsetsSet
import org.http4k.core.Body
import org.http4k.core.ContentType
import org.http4k.core.KAFKA_JSON_V2
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.with

@Http4kConnectAction
data class SeekOffsets(
    val group: ConsumerGroup,
    val instance: ConsumerInstanceId,
    val offsets: List<SeekOffset>
) : KafkaHttpProxyAction<Unit>(kClass()) {
    override fun toRequest() = Request(Method.POST, "/consumers/$group/instances/$instance/offsets")
        .with(Body.auto<SeekOffsetsSet>(contentType = ContentType.KAFKA_JSON_V2).toLens() of SeekOffsetsSet(offsets))
}
