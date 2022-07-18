
Encoding an object as a byte stream is serialization, reverse is deserialization

Item 85: Prefer alternatives to Java serialization
Item 86: Implement Serializable with great caution

        A major cost with serialization is that it decreases flexibility of changing class implementation.


Item 87: Consider using a custom serialized form

        The default form is likely to be appropiate for serialization if an objects physical representation is 
        idenntical to logical content.

Item 88: Write readObject methods defensively
Item 89: For instance control, prefer enum types to readResolve
Item 90: Consider serialization proxies instead of serialized instances

