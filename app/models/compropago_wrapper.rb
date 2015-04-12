class CompropagoWrapper
	Compropago.api_key = "sk_test_4ec94153af174e094"

	def create_deposit( phone, amount )
		charge =  Compropago::Charge.create({ 
			product_price: amount.to_f,
      product_name: "Deposito",
      customer_name: phone,
      customer_email: "noreply@compropago.com",
      payment_type: "OXXO"})

	end
end